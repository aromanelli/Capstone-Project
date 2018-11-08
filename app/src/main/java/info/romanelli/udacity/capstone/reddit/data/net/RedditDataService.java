package info.romanelli.udacity.capstone.reddit.data.net;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.Pair;

import java.util.List;
import java.util.concurrent.TimeUnit;

import info.romanelli.udacity.capstone.reddit.data.DataRepository;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDao;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDatabase;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPostData;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.model.SubredditData;
import info.romanelli.udacity.capstone.util.AppExecutors;

public class RedditDataService extends IntentService {

    public static final String TAG = RedditDataService.class.getSimpleName();

    public static final String KEY_FORCE_POPULATE = "forcePopulate";

    public static final String KEY_NOTIFICATION = RedditDataService.class.getPackage().getName();
    public static final String KEY_RESULT_CANCELLED = KEY_NOTIFICATION + ":cancelled";
    public static final String KEY_RESULT_FETCHED = KEY_NOTIFICATION + ":fetched";
    public static final String KEY_RESULT_FAILED = KEY_NOTIFICATION + ":failed";

    private static final String KEY_STORE_NAME = DataRepository.class.getSimpleName();
    public static final String KEY_LAST_POP_TIME = "last_populate_time";

    private SharedPreferences prefs;

    @SuppressWarnings("FieldCanBeLocal")
    private final int fetchWaitMinutes = 5;

    public RedditDataService() {
        super(RedditDataService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
        Log.d(TAG, "onHandleIntent() called with: intent = [" + intent + "], thread = [" + Thread.currentThread() + "]");

        final Context appContext = getApplicationContext();
        prefs = appContext.getSharedPreferences(KEY_STORE_NAME, Context.MODE_PRIVATE);

        if (!intent.getBooleanExtra(KEY_FORCE_POPULATE, true)) {
            long timeCurrent = TimeUnit.NANOSECONDS.toMinutes(System.nanoTime());
            long timeLastFetch = TimeUnit.NANOSECONDS.toMinutes(prefs.getLong(KEY_LAST_POP_TIME, 0));
            if ((timeLastFetch != 0) && (timeLastFetch + fetchWaitMinutes) > timeCurrent) {
                Log.i(TAG, "populateDatabase: Not enough time has elapsed to do another data populate. (L["+ timeLastFetch +"] + W["+ fetchWaitMinutes +"]) > C["+ timeCurrent +"]");
                // Notify ...
                final Intent intent2 = new Intent(KEY_NOTIFICATION);
                intent2.putExtra(KEY_RESULT_CANCELLED, Activity.RESULT_CANCELED);
                appContext.sendBroadcast(intent2);
                return;
            }
        }
        else {
            Log.i(TAG, "populateDatabase: Forcing a data populate; ignoring time elapsed since last time.");
        }

        RedditDataManager.getRedditData(
                appContext,
                new RedditDataManager.Listener() {
                    private int counter;
                    private int size;
                    @Override
                    public void fetching(int size) {
                        Log.d(TAG, "fetching: Will process [" + size + "] fetches batches! " + Thread.currentThread().getName());
                        this.size = size;
                    }
                    @Override
                    public void fetched(List<Pair<NewPostData,SubredditData>> listPairData) {
                        AppExecutors.$().diskIO().execute(() -> {
                            counter++; // Do this INSIDE of thread, not in method that calls thread!
                            Log.d(TAG, "fetched: Adding ["+ listPairData.size() +"] more records. ["+ counter +"] of ["+ size +"] ["+ listPairData.get(0).second.getDisplayNamePrefixed() +"] " + Thread.currentThread().getName());

                            NewPostDao daoNewPost = NewPostDatabase.$(appContext).daoNewPost();

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
                                // Unix timestamp values are in seconds, not millisecs!
                                entity.setCreated( (long)newPostData.getCreatedUtc() * 1000 );
                                entity.setAuthor(newPostData.getAuthor());
                                // Write NewPostEntity to the database ...
                                // Log.d(TAG, "fetched: Adding: " + entity.getId() + " | " + entity.getSubreddit_pre());
                                daoNewPost.insert(entity);
                            });

                            // If done fetching all new posts for all subreddits,
                            // update last fetched time, and do notification ...
                            if (counter >= size) { // All subreddits have been processed
                                setLastPopulateTime();
                                // Notify ...
                                final Intent intent = new Intent(KEY_NOTIFICATION);
                                intent.putExtra(KEY_RESULT_FETCHED, Activity.RESULT_OK);
                                appContext.sendBroadcast(intent);
                            }

                        });
                    }
                    @Override
                    public void failed(final Throwable t) {
                        Log.d(TAG, "failed() called with: t = [" + t + "]");
                        // Notify ...
                        final Intent intent = new Intent(KEY_NOTIFICATION);
                        intent.putExtra(KEY_RESULT_FAILED, t);
                        appContext.sendBroadcast(intent);
                    }
                }
        );
    }

    public void setLastPopulateTime() {
        // Remember the time the successful populate was done ...
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(KEY_LAST_POP_TIME, System.nanoTime());
        editor.apply();
    }

}
