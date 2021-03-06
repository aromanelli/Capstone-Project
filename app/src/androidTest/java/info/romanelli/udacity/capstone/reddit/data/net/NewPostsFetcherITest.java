package info.romanelli.udacity.capstone.reddit.data.net;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicBoolean;

import info.romanelli.udacity.capstone.TestUtil;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.NewPostsFetcher;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPosts;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;
import info.romanelli.udacity.capstone.util.NetUtil;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NewPostsFetcherITest {

    private static final String TAG = NewPostsFetcherITest.class.getSimpleName();

    @Test
    public void fetchNewPosts() {

        TestUtil.setNetworkAccess(true);

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("info.romanelli.udacity.capstone", appContext.getPackageName());

        NetUtil.registerForNetworkMonitoring(appContext);
        Assert.assertTrue(NetUtil.isConnected());

        // If below fails, try running the app to authorize app by user!
        Assert.assertTrue(RedditAuthManager.isAuthorized(appContext));

        final AtomicBoolean flag = new AtomicBoolean(false);
        try {

            NewPostsFetcher.fetchNewPosts(
                    "gaming",
                    appContext,
                    new NewPostsFetcher.Listener() {
                        @Override
                        public void fetched(NewPosts newposts) {
                            int size = 0;
                            if (newposts != null && newposts.getNewPostsData() != null && newposts.getNewPostsData().getNewPosts() != null) {
                                Log.d(TAG, "fetched: Number of newposts: " + newposts.getNewPostsData().getNewPosts().size());
                                size = newposts.getNewPostsData().getNewPosts().size();
                                newposts.getNewPostsData().getNewPosts().forEach(newpost -> {
                                    if (newpost.getNewPostData() != null) {
                                        Log.d(TAG, "accept: fetched newpost 1: " + newpost.getNewPostData().getTitle());
                                        //////////////////////////////////////////////////
                                        // Field 'edited' can be either a boolean or double!
                                        Object edited = newpost.getNewPostData().getEdited();
                                        String className = ((edited != null) ? edited.getClass().getSimpleName() : "null");
                                        //////////////////////////////////////////////////
                                        Log.d(TAG, "accept: fetched newpost 2: " + edited + "|" + className);
                                    } else {
                                        Log.d(TAG, "accept: fetched newpost: UNKNOWN");
                                    }
                                });
                            } else {
                                Log.d(TAG, "fetched: Number of newposts: 0");
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
