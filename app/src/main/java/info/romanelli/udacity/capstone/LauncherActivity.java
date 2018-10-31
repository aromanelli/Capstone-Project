package info.romanelli.udacity.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

import info.romanelli.udacity.capstone.reddit.data.DataRepository;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;

import static info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager.RC_AUTH;

public class LauncherActivity extends AppCompatActivity {

    final static private String TAG = LauncherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        if (!RedditAuthManager.isAuthorized(this)) {
            RedditAuthManager.performAuthRequest(this, RC_AUTH);
        } else {
            Log.d(TAG, "onCreate: Authorized");
            // TODO AOR LAUNCH MainActivity and fetch data
            populateDatabase(); // TODO Move this to right location
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == RC_AUTH) {
            AuthorizationResponse resp = AuthorizationResponse.fromIntent(intent);
            AuthorizationException excp = AuthorizationException.fromIntent(intent);
            // Uri uriRedirect = getIntent().getData();
            RedditAuthManager.performTokenRequest(
                    this,
                    resp,
                    excp,
                    (accessToken, idToken, ex) -> {
                        if (ex != null) {
                            // negotiation for fresh tokens failed, check ex for more details
                            Log.e(TAG, "performTokenRequest: ex", ex);
                        } else {
                            populateDatabase(); // TODO Move this to right location
                        }
                    }
            );
        }
    }

    private void populateDatabase() {
        DataRepository.$(this).populateDatabase(this);
    }

}
