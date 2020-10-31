package info.romanelli.udacity.capstone.reddit.data.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import info.romanelli.udacity.capstone.TestUtil;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPostData;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;
import info.romanelli.udacity.capstone.reddit.data.net.subreddits.model.SubredditData;
import info.romanelli.udacity.capstone.util.NetUtil;

import static org.junit.Assert.assertEquals;

public class RedditDataManagerITest {

    private static final String TAG = RedditDataManagerITest.class.getSimpleName();

    @Test
    public void fetchData() {

        TestUtil.setNetworkAccess(true);

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("info.romanelli.udacity.capstone", appContext.getPackageName());

        NetUtil.registerForNetworkMonitoring(appContext);
        Assert.assertTrue(NetUtil.isConnected());

        // If below fails, try running the app to authorize app by user!
        Assert.assertTrue(RedditAuthManager.isAuthorized(appContext));

        final AtomicBoolean done = new AtomicBoolean(false);
        try {

            RedditDataManager.getRedditData(appContext, new RedditDataManager.Listener() {
                private int counter;
                private int size;
                @Override
                public void fetching(int size) {
                    this.size = size;
                }
                @Override
                public void fetched(List<Pair<NewPostData,SubredditData>> listPairData) {
                    Log.d(TAG, "fetched:Thread: " + Thread.currentThread().getName());
                    counter++;
                    if (counter >= size) {
                        done.set(true);
                    }

                    // TODO Too arbitrary of a test value, always assumes at least one new post in subreddit!
                    Assert.assertTrue(listPairData.size() > 0);

                    listPairData.forEach(newPairData -> {
                        Assert.assertNotNull(newPairData.first);
                        Assert.assertNotNull(newPairData.second);
                    });
                }
                @Override
                public void failed(Throwable t) {
                    done.set(true);
                    Assert.fail(t.getLocalizedMessage());
                }
            });

            int waitCounter = 0;
            while (!done.get()) {
                Thread.sleep(250);
                waitCounter++;
                if (waitCounter % 4 == 0) {
                    Log.d(TAG, "fetchData: Waiting for completion ... ["+ (waitCounter / 4) +"]");
                }
                if (waitCounter > 2400) { // 250 * 2400 = 600,000ms == 60 seconds
                    Assert.fail("Interrupted while waiting for completion!");
                    break;
                }
            }

        } catch (Throwable t) {
            Assert.fail(t.getLocalizedMessage());
        }

    }

}
