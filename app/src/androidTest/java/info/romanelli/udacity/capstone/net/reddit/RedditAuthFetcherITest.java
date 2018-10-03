package info.romanelli.udacity.capstone.net.reddit;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

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
public class RedditAuthFetcherITest {

    final static private String TAG = RedditAuthFetcherITest.class.getSimpleName();

    @Test
    public void userRedditAcctAuth() {

        TestUtil.setNetworkAccess(true);

        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("info.romanelli.udacity.capstone", appContext.getPackageName());

        /*
        <receiver
            android:name=".RedditUserAuthReceiver"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
                <data android:host="@string/reddit_redirect_uri_host_capstone"
                    android:scheme="@string/reddit_redirect_uri_scheme_capstone"
                    android:path="@string/reddit_redirect_uri_path_capstone" />
            </intent-filter>
        </receiver>
         */

//        try {
//            ActivityInfo p = appContext.getPackageManager().getReceiverInfo(
//                    ComponentName.createRelative(
//                            appContext.getPackageName(),
//                            RedditUserAuthReceiver.class.getCanonicalName()
//                    ),
//                    0//PackageManager.GET_INTENT_FILTERS
//            );
//            Log.d(TAG, "userRedditAcctAuth: " + p);
////            for (ActivityInfo activityInfo : p.activities) {
////                Log.d(TAG, "userRedditAcctAuth: " + activityInfo.name + " " + activityInfo.packageName);
////            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }

        // if !found then there's no app on the device that can handle showing a web page
        Assert.assertTrue(
                RedditAuthFetcher.userRedditAuth(appContext, true)
        );

        Log.d(TAG, "userRedditAcctAuth: 1 >>> " + Thread.currentThread().getName());
        for (int i = 0; i < 600; i++) {
            try {
                Thread.sleep(1000);
                if (i%10 == 0) {
                    Log.d(TAG, "userRedditAcctAuth: waiting ... [" + (i + 1) + "]");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "userRedditAcctAuth: 2 >>> " + Thread.currentThread().getName());

    }

}
