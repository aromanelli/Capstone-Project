package info.romanelli.udacity.capstone.reddit.data.net;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicBoolean;

import info.romanelli.udacity.capstone.TestUtil;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.SubredditsFetcher;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.model.Subreddits;
import info.romanelli.udacity.capstone.util.NetUtil;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SubredditsFetcherITest {

    final static private String TAG = SubredditsFetcherITest.class.getSimpleName();

    @Test
    public void fetchSubreddits() {

        TestUtil.setNetworkAccess(true);

        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("info.romanelli.udacity.capstone", appContext.getPackageName());

        NetUtil.registerForNetworkMonitoring(appContext);
        Assert.assertTrue(NetUtil.isConnected());

        // If below fails, try running the app to authorize app by user!
        Assert.assertTrue(RedditAuthManager.isAuthorized(appContext));

        final AtomicBoolean flag = new AtomicBoolean(false);
        try {

            SubredditsFetcher.fetchSubscribed(
                    appContext,
                    new SubredditsFetcher.Listener() {
                        @Override
                        public void fetched(Subreddits subreddits) {
                            int size = 0;
                            if (subreddits != null && subreddits.getSubredditsData() != null && subreddits.getSubredditsData().getSubreddits() != null) {
                                Log.d(TAG, "fetched: Number of subreddits: " + subreddits.getSubredditsData().getSubreddits().size());
                                size = subreddits.getSubredditsData().getSubreddits().size();
                                subreddits.getSubredditsData().getSubreddits().forEach(subreddit -> {
                                    if (subreddit.getSubredditData() != null) {
                                        Log.d(TAG, "accept: fetched Subreddit: " + subreddit.getSubredditData().getTitle());
                                    } else {
                                        Log.d(TAG, "accept: fetched Subreddit: UNKNOWN");
                                    }
                                });
                            } else {
                                Log.d(TAG, "fetched: Number of subreddits: 0");
                            }
                            flag.set(true);
                            Assert.assertTrue(size > 0);
                        }
                        @Override
                        public void failed(Throwable t) {
                            Log.e(TAG, "failed: ", t);
                            flag.set(true);
                            Assert.fail(t.getLocalizedMessage());
                        }
                    }
            );

            int waitCounter = 0;
            while (!flag.get()) {
                Thread.sleep(250);
                waitCounter++;
                if (waitCounter > 160) { // 250 * 160 = 40,000ms == 40 seconds
                    Assert.fail("Interrupted while waiting for response back!");
                    break;
                }
            }

        } catch (Throwable t) {
            Assert.fail(t.getLocalizedMessage());
        }

    }

}
