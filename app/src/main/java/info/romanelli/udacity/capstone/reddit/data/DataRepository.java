package info.romanelli.udacity.capstone.reddit.data;

import android.app.AlertDialog;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;
import android.util.Pair;

import java.util.List;

import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDao;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDatabase;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.net.RedditDataManager;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPostData;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.model.SubredditData;
import info.romanelli.udacity.capstone.reddit.data.util.AppExecutors;

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

    private DataRepository(final Context context) {
        NewPostDatabase db = NewPostDatabase.$(context.getApplicationContext());
        daoNewPost = db.daoNewPost();
        ldNewPosts = daoNewPost.getNewPosts();
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

}
