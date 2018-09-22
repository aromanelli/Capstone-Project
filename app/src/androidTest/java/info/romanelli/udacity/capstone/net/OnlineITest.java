package info.romanelli.udacity.capstone.net;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import info.romanelli.udacity.capstone.TestUtil;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class OnlineITest {

    final static private String TAG = OnlineITest.class.getSimpleName();

    @Test
    public void isOnline() {

        TestUtil.setNetworkAccess(true);

        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("info.romanelli.udacity.capstone", appContext.getPackageName());

        Assert.assertTrue(NetUtil.isOnline(appContext));

        TestUtil.setNetworkAccess(false);

        Assert.assertFalse(NetUtil.isOnline(appContext));

        // NetUtil.ifOffline(appContext, null); // TODO CODE THIS!

        TestUtil.setNetworkAccess(true);

        Assert.assertTrue(NetUtil.isOnline(appContext));
    }

}
