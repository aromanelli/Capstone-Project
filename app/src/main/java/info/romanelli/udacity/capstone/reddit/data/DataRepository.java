package info.romanelli.udacity.capstone.reddit.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import info.romanelli.udacity.capstone.reddit.data.db.NewPostDao;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDatabase;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.net.RedditDataService;
import info.romanelli.udacity.capstone.util.AppExecutors;

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

        createSubredditsInfo();
        final Observer<List<NewPostEntity>> obs1 = newPostEntities -> {
            Log.d(TAG, "DataRepository: Observed changing new posts data");
            createSubredditsInfo();
        };
        ldNewPosts.observeForever(obs1); // TODO Need to removeObserver for a singleton class?
    }

    synchronized private void createSubredditsInfo() {
        Log.d(TAG, "createSubredditsInfo() called");
        // Create the sorted Set of Subreddits ...
        if (ldNewPosts.getValue() != null) {
            subredditsInfo.clear();
            ldNewPosts.getValue().forEach(newPostEntity ->
                    subredditsInfo.add(
                            new SubredditInfo(
                                    newPostEntity.getSubreddit_pre(),
                                    newPostEntity.getSubreddit(),
                                    newPostEntity.getSubreddit_icon()
                            )
                    )
            );
        }
    }

    synchronized public Set<SubredditInfo> getSubredditsInfo() {
        return Collections.unmodifiableSet(subredditsInfo);
    }

    public LiveData<List<NewPostEntity>> getNewPosts() {
        return ldNewPosts;
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

    static class SubredditInfo implements Comparable<SubredditInfo> {

        private String subreddit_pre;
        private String subreddit;
        private String subreddit_icon;

        public SubredditInfo(@NonNull final String subreddit_pre,
                             @NonNull final String subreddit,
                             final String subreddit_icon) {
            setPrefixedSubreddit(subreddit_pre);
            setSubreddit(subreddit);
            setSubredditIcon(subreddit_icon);
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
        public String toString() {
            return "SubredditInfo{" +
                    "subreddit_pre='" + subreddit_pre + '\'' +
                    ", subreddit='" + subreddit + '\'' +
                    ", subreddit_icon='" + subreddit_icon + '\'' +
                    '}';
        }

        @Override
        public int compareTo(SubredditInfo o) {
            return this.subreddit_pre.compareTo(o.subreddit_pre);
        }
    }

}
