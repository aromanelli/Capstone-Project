package info.romanelli.udacity.capstone.net.reddit;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.PatternMatcher;
import android.util.Log;

import java.util.List;

import info.romanelli.udacity.capstone.AppExecutors;
import info.romanelli.udacity.capstone.BuildConfig;
import info.romanelli.udacity.capstone.RedditUserAuthReceiver;

import static info.romanelli.udacity.capstone.BuildConfig.Reddit_Redirect_URI_Host_Capstone;
import static info.romanelli.udacity.capstone.BuildConfig.Reddit_Redirect_URI_Path_Capstone;
import static info.romanelli.udacity.capstone.BuildConfig.Reddit_Redirect_URI_Scheme_Capstone;

public class RedditAuthFetcher extends AbstractRedditFetcher {

    final static private String TAG = RedditAuthFetcher.class.getSimpleName();

    final static private String REDDIT_REDIRECT_URI =
            Reddit_Redirect_URI_Scheme_Capstone + "://" +
            Reddit_Redirect_URI_Host_Capstone +
            Reddit_Redirect_URI_Path_Capstone;

    private static final String AUTH_URL_TEMPLATE =
            URL_BASE + "/api/v1/authorize%s?client_id=%s" +
            "&response_type=code" +
            "&state=%s" +
            "&redirect_uri=%s" +
            "&duration=permanent" +
            "&scope=identity mysubreddits read"; // https://github.com/reddit-archive/reddit/wiki/OAuth2

//    private static final String ACCESS_TOKEN_URL =
//            "https://www.reddit.com/api/v1/access_token";

    // https://developer.android.com/reference/android/accounts/AccountManager#getAuthToken(android.accounts.Account


//    http://blog.udinic.com/2013/04/24/write-your-own-android-authenticator/
//    https://stackoverflow.com/questions/38432487/how-to-connect-to-a-oauth2-server-from-android-using-account-manager
//    https://stackoverflow.com/questions/11061211/obtain-oauth2-token-using-android-accountmanager
//    https://github.com/wuman/android-oauth-client
//    https://developer.android.com/training/id-auth/authenticate#Gather
//    https://github.com/googleapis/google-oauth-java-client
//    https://duckduckgo.com/?q=android+oauth2+library&t=canonical&atb=v135-3__&ia=software
//    https://stackoverflow.com/questions/15284727/how-to-get-google-oauth2-token-with-webview

    static public boolean userRedditAuth(Context context, final boolean compact) {

        final Context fContext = context.getApplicationContext();

        String url = String.format(
                AUTH_URL_TEMPLATE,
                (compact ? ".compact" : ""), // TODO AOR Determine to use '.compact' only on phones not tablets
                BuildConfig.Reddit_Client_Id_Capstone,
                fContext.getApplicationInfo().packageName,
                REDDIT_REDIRECT_URI // http://romanelli.info/capstone/redirect
        );
        Log.d(TAG, "userRedditAuth: URL: " + url);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        List<ResolveInfo> list = fContext.getPackageManager().queryIntentActivities(
                intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {

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

            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_VIEW);
            filter.addCategory(Intent.CATEGORY_DEFAULT);
            filter.addCategory(Intent.CATEGORY_BROWSABLE);
            Uri uriRedir = Uri.parse(REDDIT_REDIRECT_URI);
            filter.addDataScheme(uriRedir.getScheme());//Reddit_Redirect_URI_Scheme_Capstone);
            filter.addDataAuthority(uriRedir.getAuthority(), String.valueOf(uriRedir.getPort()));//Reddit_Redirect_URI_Host_Capstone + Reddit_Redirect_URI_Path_Capstone, null);
            filter.addDataPath(uriRedir.getPath(), PatternMatcher.PATTERN_LITERAL);
            final StringBuilder builder = new StringBuilder();
            builder.append(filter.getAction(0));
            builder.append(", ");
            builder.append(filter.getCategory(0));
            builder.append(", ");
            builder.append(filter.getCategory(1));
            builder.append(", ");
            builder.append(filter.getDataScheme(0));
            builder.append(", ");
            builder.append(filter.getDataAuthority(0).getHost());
            builder.append("||");
            builder.append(filter.getDataAuthority(0).getPort());
            Log.d(TAG, "userRedditAuth: filter: " + builder.toString());

            AppExecutors.$().mainUI().execute(() -> {
                Log.d(TAG, "userRedditAuth: " + Thread.currentThread().getName());
                Intent sticky = fContext.registerReceiver( new RedditUserAuthReceiver(), filter );
                if (sticky != null) {
                    Log.d(TAG, "userRedditAuth: sticky: " + sticky);
                }


//                Intent returnIntent = new Intent(Intent.ACTION_VIEW);
//                returnIntent.addCategory(Intent.CATEGORY_DEFAULT);
//                returnIntent.addCategory(Intent.CATEGORY_BROWSABLE);
//                returnIntent.setDataAndNormalize(
//                        Uri.parse(REDDIT_REDIRECT_URI)
//                                .buildUpon()
//                                .appendQueryParameter(
//                                        "state", fContext.getApplicationInfo().packageName)
//                                .build() );
//                fContext.sendBroadcast(returnIntent); // TODO Testing only

                fContext.startActivity(intent);
            });

            return true;
        } else {
            return false;
        }
    }


//    static public void fetchAuth(final RedditAuthFetcher.Listener listener) {
//
//        if (NetUtil.isConnected()) {
//
//            Call<Subreddits> call =
//                    RETROFIT.create(RedditAuthFetcher.Service.class)
//                            .fetchAuth(
//                                    // https://github.com/reddit-archive/reddit/wiki/OAuth2
//                                    BuildConfig.Reddit_Client_Id_Capstone,
//                                    "code",
//                                    BuildConfig.Reddit_App_Name_Capstone.replaceAll("\\s+",""),
//                                    REDDIT_REDIRECT_URI,
//                                    "permanent",
//                                    "identity"
//                            );
//
//            call.enqueue(new Callback<Subreddits>() {
//                @Override
//                public void onResponse(
//                        @NonNull Call<Subreddits> call,
//                        @NonNull retrofit2.Response<Subreddits> response) {
//                    if (response.body() != null) {
//                        //noinspection ConstantConditions
//                        final Subreddits subreddits = response.body();
//                        listener.fetched(subreddits);
//                    } else {
//                        listener.fetched(null);
//                    }
//                }
//                @Override
//                public void onFailure(
//                        @NonNull Call<Subreddits> call,
//                        @NonNull Throwable t) {
//                    listener.failed(t);
//                }
//            });
//
//        }
//
//    }
//
//    interface Service {
//        @GET("api/v1/authorize.compact")
//        Call<Subreddits> fetchAuth(
//                @Query("client_id") String idClient,
//                @Query("response_type") String typeResponse,
//                @Query("state") String state,
//                @Query("redirect_uri") String uriRedirect,
//                @Query("duration") String duration,
//                @Query("scope") String scope
//        );
//    }
//
//    public interface Listener {
//        void fetched(final Subreddits subbreddits);
//        void failed(final Throwable t);
//    }
    
}
