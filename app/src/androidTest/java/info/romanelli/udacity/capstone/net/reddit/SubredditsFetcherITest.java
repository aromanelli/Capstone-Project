package info.romanelli.udacity.capstone.net.reddit;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicBoolean;

import info.romanelli.udacity.capstone.TestUtil;
import info.romanelli.udacity.capstone.net.reddit.subreddits.SubredditsFetcher;
import info.romanelli.udacity.capstone.net.reddit.subreddits.model.Subreddits;

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

        final AtomicBoolean flag = new AtomicBoolean(false);
        try {

            SubredditsFetcher.fetchSubscribed(
                    new SubredditsFetcher.Listener() {
                        @Override
                        public void fetched(Subreddits subbreddits) {
                            System.out.println(subbreddits);
                            flag.set(true);
                        }

                        @Override
                        public void failed(Throwable t) {
                            System.err.println(t);
                            flag.set(true);
                            Assert.fail(t.getLocalizedMessage());
                        }
                    }
            );

            int waitcounter = 0;
            while (!flag.get()) {
                Thread.sleep(125);
                waitcounter++;
                if (waitcounter > 80) { // 125 * 80 = 10,000ms == 10 seconds
                    Assert.fail("Interrupted while waiting for response back!");
                    break;
                }
            }
        } catch (Throwable t) {
            Assert.fail(t.getLocalizedMessage());
        }

    }

}
