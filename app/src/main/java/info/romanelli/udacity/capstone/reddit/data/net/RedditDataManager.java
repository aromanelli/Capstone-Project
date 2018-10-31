package info.romanelli.udacity.capstone.reddit.data.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import info.romanelli.udacity.capstone.reddit.data.net.newposts.NewPostsFetcher;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPostData;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPosts;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.SubredditsFetcher;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.model.SubredditData;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.model.Subreddits;
import info.romanelli.udacity.capstone.util.AppExecutors;
import info.romanelli.udacity.capstone.util.NetUtil;

public class RedditDataManager {

    final static private String TAG = RedditDataManager.class.getSimpleName();

    /**
     * <p>Will move the network calls off to another thread for you.</p>
     * @param context
     * @param listener See {@link RedditDataManager.Listener}
     */
    static public void getRedditData(final Context context, final Listener listener) {
        Log.d(TAG, "getRedditData:Thread: " + Thread.currentThread().getName());

        final Context appContext = context.getApplicationContext();

        NetUtil.registerForNetworkMonitoring(appContext);
        if (!NetUtil.isConnected()) {
            listener.failed(new IllegalStateException("Expected a valid net connection."));
        }

        if (!RedditAuthManager.isAuthorized(appContext)) {
            listener.failed(new IllegalStateException("Expected a valid Reddit authorization."));
        }

        fetchSubreddits(appContext, listener);
    }

    static private void fetchSubreddits(final Context appContext, final Listener listener) {
        AppExecutors.$().netIO().execute(() -> {
            Log.d(TAG, "fetchSubreddits:Thread: " + Thread.currentThread().getName());
            SubredditsFetcher.fetchSubscribed(
                    appContext,
                    new SubredditsFetcher.Listener() {
                        @Override
                        public void fetched(Subreddits subreddits) {
                            // Gets called on the 'Main' thread, so we
                            // move back off to the 'Net I/O' thread ...
                            AppExecutors.$().netIO().execute(() -> {
                                final List<SubredditData> subredditData = new ArrayList<>();
                                if (subreddits != null &&
                                        subreddits.getSubredditsData() != null &&
                                        subreddits.getSubredditsData().getSubreddits() != null) {
                                    subreddits.getSubredditsData().getSubreddits().forEach(subreddit -> {
                                        if (subreddit.getSubredditData() != null) {
                                            subredditData.add(subreddit.getSubredditData());
                                        }
                                    });
                                }
                                fetchNewPosts(appContext, subredditData, listener);
                            });
                        }

                        @Override
                        public void failed(Throwable t) {
                            Log.e(TAG, "failed: ", t);
                            listener.failed(t);
                        }
                    }
            );
        });
    }

    static private void fetchNewPosts(final Context appContext,
                                      final List<SubredditData> subredditDataList,
                                      final Listener listener) {
        Log.d(TAG, "fetchNewPosts:Thread: " + Thread.currentThread().getName());
        listener.fetching(subredditDataList.size());
        subredditDataList.forEach(
                subredditData -> {
                    Log.d(TAG, "fetchNewPosts|SubredditData: [" + subredditData.getTitle() + "][" + subredditData.getDisplayName() + "][" + subredditData.getUrl() + "]");
                    NewPostsFetcher.fetchNewPosts(
                            subredditData.getDisplayName(),
                            appContext,
                            new NewPostsFetcher.Listener() {
                                @Override
                                public void fetched(NewPosts newposts) {
                                    final List<Pair<NewPostData,SubredditData>> listNewPostsData = new ArrayList<>();
                                    if (newposts != null &&
                                            newposts.getNewPostsData() != null &&
                                            newposts.getNewPostsData().getNewPosts() != null) {
                                        // For each new post, add it to the collection that will be returned,
                                        // also adding to the collection the subreddit data for the new post ...
                                        newposts.getNewPostsData().getNewPosts().forEach(newpost -> {
                                            if (newpost.getNewPostData() != null) {
                                                Log.d(TAG, "fetchNewPosts|NewPostData: [" + newpost.getNewPostData().getSubreddit() + "][" + newpost.getNewPostData().getTitle() + "]");
                                                listNewPostsData.add(
                                                        new Pair<>(
                                                                newpost.getNewPostData(),
                                                                subredditData
                                                        )

                                                );
                                            }
                                        });
                                    }
                                    listener.fetched(listNewPostsData);
                                }
                                @Override
                                public void failed(Throwable t) {
                                    Log.e(TAG, "failed: ", t);
                                    listener.failed(t);
                                }
                            }
                    );
                }
        );
    }

    public interface Listener {
        /**
         * <p>Called when the number of times {@link #fetched(List)}
         * will be called is known, before the calls happen.</p>
         * @param size
         */
        void fetching(int size);

        /**
         * <p>Will be called on the 'main' thread!</p>
         * @param listPairData Containing both the new post data, but as well
         *                     the subreddit data the new post was posted to
         */
        void fetched(final List<Pair<NewPostData,SubredditData>> listPairData);

        /**
         * <p>Called when an error occurs on any of the fetches.</p>
         * @param t
         */
        void failed(final Throwable t);
    }

}
