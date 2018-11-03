package info.romanelli.udacity.capstone;

import android.support.v7.app.AppCompatActivity;

/**
 * @deprecated Replaced by NewPostListActivity
 */
@Deprecated
public class LauncherActivity extends AppCompatActivity {
//
//    final static private String TAG = LauncherActivity.class.getSimpleName();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_launcher);
//
//        if (!RedditAuthManager.isAuthorized(this)) {
//            RedditAuthManager.performAuthRequest(this, RC_AUTH);
//        } else {
//            Log.d(TAG, "onCreate: Authorized");
//            populateDatabase();
//        }
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        if (requestCode == RC_AUTH) {
//            AuthorizationResponse resp = AuthorizationResponse.fromIntent(intent);
//            AuthorizationException excp = AuthorizationException.fromIntent(intent);
//            // Uri uriRedirect = getIntent().getData();
//            RedditAuthManager.performTokenRequest(
//                    this,
//                    resp,
//                    excp,
//                    (accessToken, idToken, ex) -> {
//                        if (ex != null) {
//                            // negotiation for fresh tokens failed, check ex for more details
//                            Log.e(TAG, "performTokenRequest: ex", ex);
//                        } else {
//                            populateDatabase();
//                        }
//                    }
//            );
//        }
//    }
//
//    private void populateDatabase() {
//        DataRepository.$(this).populateDatabase(this);
//    }
//
}
