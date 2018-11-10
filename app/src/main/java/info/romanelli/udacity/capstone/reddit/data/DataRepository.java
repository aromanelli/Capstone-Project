package info.romanelli.udacity.capstone.reddit.data;

import android.appwidget.AppWidgetManager;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import info.romanelli.udacity.capstone.RedditInfoWidget;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDao;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDatabase;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.net.RedditDataService;
import info.romanelli.udacity.capstone.util.AppExecutors;
import info.romanelli.udacity.capstone.util.Assert;

public class DataRepository {

    final static private String TAG = DataRepository.class.getSimpleName();

    private static volatile DataRepository INSTANCE;

    public static DataRepository $(final Context context) {
        if (INSTANCE == null) {
            synchronized (NewPostDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository(context);
                }
            }
        }
        return INSTANCE;
    }

    private NewPostDao daoNewPost;
    private LiveData<List<NewPostEntity>> ldNewPosts;
    private SortedSet<SubredditInfo> subredditsInfo = new TreeSet<>();

    private DataRepository(final Context context) {

        daoNewPost = NewPostDatabase.$(context.getApplicationContext()).daoNewPost();
        ldNewPosts = daoNewPost.getNewPosts();

        createSubredditsInfo(context);
        final Observer<List<NewPostEntity>> obs1 = newPostEntities -> {
            Log.d(TAG, "DataRepository: Observed changing new posts data");
            createSubredditsInfo(context);
        };
        ldNewPosts.observeForever(obs1); // TODO Need to removeObserver for a singleton class?
    }

    synchronized private void createSubredditsInfo(final Context context) {
        Log.d(TAG, "createSubredditsInfo() called");
        // Create the sorted Set of Subreddits ...
        if (ldNewPosts.getValue() != null) {
            subredditsInfo.clear();
            final Map<String, Integer> map = new TreeMap<>();
            ldNewPosts.getValue().forEach(newPostEntity -> {
                // Track how many new posts per subreddit ...
                SubredditInfo si = subredditsInfo.stream()
                        .filter(subredditInfo ->
                                subredditInfo.subreddit_pre.equals(newPostEntity.getSubreddit_pre()))
                        .findFirst().orElseGet(() ->
                                new SubredditInfo(
                                        newPostEntity.getSubreddit_pre(),
                                        newPostEntity.getSubreddit(),
                                        newPostEntity.getSubreddit_icon(),
                                        0
                                )
                        );
                // Increment both the existing subreddit counter,
                // or the new/first time subreddit entry counter ...
                si.setSizeNewposts(si.getSizeNewposts() + 1);
                // Below only adds the first subreddit entry, n+1's are ignored!
                subredditsInfo.add(si);
            });

            // Let widgets know that the counts has (potentially) changed ...
            broadcastToWidgets(context);
        }
    }

    private void broadcastToWidgets(final Context context) {
        Intent intent = new Intent(context.getApplicationContext(), RedditInfoWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(RedditInfoWidget.class.getSimpleName(), new Date());

        // Use an array and EXTRA_APPWIDGET_IDS instead of AppWidgetManager.EXTRA_APPWIDGET_ID,
        // since it seems the onUpdate() is only fired on that:
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context.getApplicationContext());
        int ids[] = appWidgetManager.getAppWidgetIds(
                new ComponentName(context.getApplicationContext(), RedditInfoWidget.class)
        );
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        context.getApplicationContext().sendBroadcast(intent);
    }

    synchronized public Set<SubredditInfo> getSubredditsInfo() {
        return Collections.unmodifiableSet(subredditsInfo);
    }

    public LiveData<List<NewPostEntity>> getNewPosts() {
        return ldNewPosts;
    }

    public int sizeNewPosts() {
        if (ldNewPosts.getValue() != null) {
            return ldNewPosts.getValue().size();
        } else {
            return 0;
        }
    }

    public NewPostEntity getNewPostEntity(final String idToFind) {
        if (idToFind == null || idToFind.trim().length() <= 0) {
            throw new IllegalArgumentException("Expected a valid NewPostEntity id to search on!");
        }
        List<NewPostEntity> list = ldNewPosts.getValue();
        Assert.that(list != null);
        Optional<NewPostEntity> result =
                list.stream().filter(
                        newPostEntity -> idToFind.equals(newPostEntity.getId())
                ).findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new AssertionError("Unable to find NewPostEntity with id of ["+ idToFind +"]!");
        }
    }



    public void clearDatabase() {
        AppExecutors.$().diskIO().execute(() -> daoNewPost.deleteAllNewPosts());
    }

    /**
     * Gets rid of any new posts that are older than a day.
     */
    public void pruneDatabase() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.roll(Calendar.DAY_OF_MONTH, -1); // See also RedditDataService
        pruneDatabase(calendar.getTime());
    }

    public void pruneDatabase(Date pruneThresholdDate) {
        pruneDatabase(pruneThresholdDate.getTime());
    }

    public void pruneDatabase(long pruneThresholdDate) {
        AppExecutors.$().diskIO().execute(() -> daoNewPost.pruneNewPosts(pruneThresholdDate));
    }

    public void addNewPost(final NewPostEntity newPostEntity) {
        AppExecutors.$().diskIO().execute(() -> daoNewPost.insert(newPostEntity));
    }

    /**
     * <p>Calls the {@link RedditDataService}, which will fetch
     * new Reddit posts, and store them in the local database.</p>
     *
     * <p>Note that if two populate requests are done, one right after another,
     * the latter call will be ignored, as not enough time has elapsed yet.</p>
     *
     * @param context
     */
    public void populateDatabase(final Context context) {
        populateDatabase(context, false);
    }

    /**
     * <p>Calls the {@link RedditDataService}, which will fetch
     * new Reddit posts, and store them in the local database.</p>
     *
     * @param context
     * @param forcePopulate if {@code true} then a fetch/insert will be done even if one was just done recently.
     */
    synchronized public void populateDatabase(final Context context, boolean forcePopulate) {
        // Call the service to fetch new posts from Reddit and write them to the local db ...
        final Context appContext = context.getApplicationContext();
        Intent intent = new Intent(context, RedditDataService.class);
        intent.putExtra(RedditDataService.KEY_FORCE_POPULATE, forcePopulate);
        appContext.startService(intent);
    }

    public static class SubredditInfo implements Comparable<SubredditInfo> {

        private String subreddit_pre;
        private String subreddit;
        private String subreddit_icon;
        private long sizeNewPosts;

        public SubredditInfo(@NonNull final String subreddit_pre,
                             @NonNull final String subreddit,
                             final String subreddit_icon,
                             final long sizeNewPosts) {
            setPrefixedSubreddit(subreddit_pre);
            setSubreddit(subreddit);
            setSubredditIcon(subreddit_icon);
            setSizeNewposts(sizeNewPosts);
        }

        public String getPrefixedSubreddit() {
            return subreddit_pre;
        }

        public void setPrefixedSubreddit(String subreddit_pre) {
            this.subreddit_pre = subreddit_pre;
        }

        public String getSubreddit() {
            return subreddit;
        }

        public void setSubreddit(String subreddit) {
            this.subreddit = subreddit;
        }

        public String getSubredditIcon() {
            return subreddit_icon;
        }

        public void setSubredditIcon(String subreddit_icon) {
            this.subreddit_icon = subreddit_icon;
        }

        public long getSizeNewposts() {
            return sizeNewPosts;
        }

        public void setSizeNewposts(long sizeNewPosts) {
            this.sizeNewPosts = sizeNewPosts;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SubredditInfo that = (SubredditInfo) o;
            return Objects.equals(subreddit_pre, that.subreddit_pre);
        }

        @Override
        public int hashCode() {

            return Objects.hash(subreddit_pre);
        }

        @Override
        public int compareTo(SubredditInfo o) {
            return this.subreddit_pre.compareTo(o.subreddit_pre);
        }

        @Override
        public String toString() {
            return "SubredditInfo{" +
                    "subreddit_pre='" + subreddit_pre + '\'' +
                    ", subreddit='" + subreddit + '\'' +
                    ", subreddit_icon='" + subreddit_icon + '\'' +
                    ", sizeNewPosts=" + sizeNewPosts +
                    '}';
        }
    }

}
