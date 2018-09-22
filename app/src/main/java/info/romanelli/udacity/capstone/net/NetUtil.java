package info.romanelli.udacity.capstone.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import info.romanelli.udacity.capstone.R;

public class NetUtil {

    final static private String TAG = NetUtil.class.getSimpleName();

    static public boolean ifOffline(final Context context, final View view, final int showDuration) {
        if (isOnline(context)) {
            return true;
        }
        else {
            Snackbar.make(view, R.string.msg_offline, Snackbar.LENGTH_LONG).setDuration(showDuration).show();
            return false;
        }
    }

    static public boolean isOnline(final Context context) {
        final boolean flag;
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            flag = (netInfo != null) && netInfo.isConnectedOrConnecting();
        } else {
            Log.w(TAG, "isOnline: Unable to obtain a ConnectivityManager reference! " + Thread.currentThread().getName());
            flag = false;
        }
        Log.d(TAG, "isOnline: Online? " + flag);
        return flag;
    }

}
