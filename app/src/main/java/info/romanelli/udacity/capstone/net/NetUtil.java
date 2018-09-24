package info.romanelli.udacity.capstone.net;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import info.romanelli.udacity.capstone.R;

@SuppressWarnings("unused")
public class NetUtil {

    final static private String TAG = NetUtil.class.getSimpleName();

    static private boolean CONNECTED = false;
    static private ConnectivityManager.NetworkCallback NETCALLBACK;

    static public boolean ifConnected(final View view, final int showDuration) throws IllegalStateException {
        if (!isConnected()) {
            Snackbar.make(view, R.string.msg_offline, Snackbar.LENGTH_LONG).setDuration(showDuration).show();
            return false;
        }
        return true;
    }

    static public boolean isConnected() throws IllegalStateException {
        if (NETCALLBACK != null) {
            return CONNECTED;
        }
        throw new IllegalStateException("Not yet registered for network monitoring!");
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    synchronized static public void registerForNetworkMonitoring(final Context context) throws IllegalStateException {

        if (NETCALLBACK == null) {

            // Configure initial network state ...
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                CONNECTED = (netInfo != null) && netInfo.isConnected();
            }

            // Configure callback/listener for network state changes ...
            NETCALLBACK = new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    Log.d(TAG, "onAvailable() called with: network = [" + network + "]");
                    // https://developer.android.com/reference/android/net/ConnectivityManager.NetworkCallback#onAvailable(android.net.Network)
                    CONNECTED = true;
                    context.getApplicationContext().sendBroadcast(getIntent());
                }
                @Override
                public void onLost(Network network) {
                    Log.d(TAG, "onLost() called with: network = [" + network + "]");
                    CONNECTED = false;
                    context.getApplicationContext().sendBroadcast(getIntent());
                }
                private Intent getIntent() {
                    Intent intent = new Intent();
                    intent.setAction(context.getApplicationContext().getPackageName() + "CONNECTIVITY_CHANGE");
                    intent.putExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, (!CONNECTED));
                    return intent;
                }
            };

            // Regiseter callback/listener for network state changes ...
            ConnectivityManager connMgr =
                    (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connMgr != null) {
                connMgr.registerNetworkCallback(new NetworkRequest.Builder().build(), NETCALLBACK);
            }

        } else {
            throw new IllegalStateException("Already registered for network monitoring!");
        }

    }

}
