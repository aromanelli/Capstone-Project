package info.romanelli.udacity.capstone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class RedditUserAuthReceiver extends BroadcastReceiver {

    final static private String TAG = RedditUserAuthReceiver.class.getSimpleName();

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Log.d(TAG, "onReceive() called with: context = [" + context + "], intent = [" + intent + "]");

        // adb shell dumpsys activity broadcasts history

        // http://romanelli.info/capstone/redirect?state=UdacityCapstoneRedditViewer&code=2toAd7PNd7BOkOWYBAmgXCrJx2c

        if ( (intent != null) && Intent.ACTION_VIEW.equals(intent.getAction()) ) {
            Uri uri = intent.getData();
            if (uri != null) {
                if (uri.getQueryParameter("error") != null) {
                    String error = uri.getQueryParameter("error");
                    Log.e(TAG, "An error has occurred : " + error);
                } else {
                    String state = uri.getQueryParameter("state");
                    if (context.getApplicationInfo().packageName.equals(state)) {
                        getAccessToken(uri.getQueryParameter("code"));
                        context.getApplicationContext().unregisterReceiver(this);
                    }
                }
            }
        }

    }

    private void getAccessToken(final String code) {
        Log.d(TAG, "getAccessToken() called with: code = [" + code + "]");
        // https://progur.com/2016/10/how-to-use-reddit-oauth2-in-android-apps.html
    }

}
