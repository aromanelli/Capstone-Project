package info.romanelli.udacity.capstone.reddit.data;

import android.app.AlertDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDao;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDatabase;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.net.RedditDataManager;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPostData;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.model.SubredditData;
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

        NewPostDatabase db = NewPostDatabase.$(context.getApplicationContext());

        daoNewPost = db.daoNewPost();
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
        AppExecutors.$().diskIO().execute(() -> daoNewPost.deleteNewPosts());
    }

    public void pruneDatabase() {
        AppExecutors.$().diskIO().execute(() -> daoNewPost.pruneNewPosts());
    }

    public void addNewPost(final NewPostEntity newPostEntity) {
        AppExecutors.$().diskIO().execute(() -> daoNewPost.insert(newPostEntity));
    }

    /**
     * <p>Will move the network calls and database populating off to other threads for you.</p>
     * @param context
     */
    public void populateDatabase(final Context context) {

        final Context appContext = context.getApplicationContext();
        RedditDataManager.getRedditData(appContext, new RedditDataManager.Listener() {
            private int counter;
            private int size;
            @Override
            public void fetching(int size) {
                Log.d(TAG, "fetching: Will receive [" + size + "] fetches! " + Thread.currentThread().getName());
                this.size = size;
            }
            @Override
            public void fetched(List<Pair<NewPostData,SubredditData>> listPairData) {
                Log.d(TAG, "fetched: ["+ (counter+1) +"] of ["+ size +"] " + Thread.currentThread().getName());
                counter++;
                AppExecutors.$().diskIO().execute(() -> {
                    Log.d(TAG, "fetched: Adding ["+ listPairData.size() +"] records");
                    listPairData.forEach(pairData -> {
                        // Pull the data out of the Pair ...
                        NewPostData newPostData = pairData.first;
                        SubredditData subredditData = pairData.second;
                        // Create a NewPostEntity and populate with ...
                        final NewPostEntity entity = new NewPostEntity();
                        entity.setId(newPostData.getId());
                        entity.setUrl(newPostData.getUrl());
                        entity.setText(newPostData.getSelftext());
                        entity.setTitle(newPostData.getTitle());
                        entity.setSubreddit_icon(subredditData.getIconImg());
                        entity.setSubreddit(newPostData.getSubreddit());
                        entity.setSubreddit_pre(newPostData.getSubredditNamePrefixed());
                        entity.setCreated( (long) newPostData.getCreatedUtc() ); // DOUBLE vs LONG ?
                        entity.setAuthor(newPostData.getAuthor());
                        // Write NewPostEntity to the database ...
                        Log.d(TAG, "fetched: Adding: " + entity);
                        daoNewPost.insert(entity);
                    });
                });
            }
            @Override
            public void failed(final Throwable t) {
                AppExecutors.$().mainUI().execute(() -> {
                    AlertDialog.Builder adb = new AlertDialog.Builder(context); // NOT appContext !
                    adb.setTitle(appContext.getString(R.string.fetch_error_title));
                    adb.setMessage(appContext.getString(R.string.fetch_error_text));
                    adb.setNegativeButton(
                            appContext.getString(R.string.exit),
                            (dialog, idBtn) -> {
                                // if (DialogInterface.BUTTON_POSITIVE == idBtn) {
                                dialog.dismiss();
                                System.exit(t.hashCode() * -1);
                            }
                    );
                    adb.show();
                });
            }
        });

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
