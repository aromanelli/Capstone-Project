package info.romanelli.udacity.capstone.net.reddit.oauth;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.ClientSecretBasic;
import net.openid.appauth.ResponseTypeValues;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import info.romanelli.udacity.capstone.AppExecutors;
import info.romanelli.udacity.capstone.BuildConfig;

public class RedditAuthManager {

    final static private String TAG = RedditAuthManager.class.getSimpleName();

    final static public String STATE = "info.romanelli.udacity.capstone";

    final static private String URL_BASE = "https://www.reddit.com";

    static public boolean isAuthorized(final Context context) {
        return AuthStateManager.$(context).getAuthState().isAuthorized();
    }

    /**
     * <p></p>
     *
     * @param context
     * @param completedActivity
     * @param canceledActivity
     */
    synchronized static public void performAuthRequest(final Context context,
                                                       final Class<?> completedActivity,
                                                       final Class<?> canceledActivity) {
        AppExecutors.$().netIO().execute(() -> {
            // https://github.com/openid/AppAuth-Android/blob/master/README.md
            final AuthorizationService authService = new AuthorizationService(context);
            final AuthorizationRequest authRequest = getAuthRequest(context);
            authService.performAuthorizationRequest(
                    authRequest,
                    PendingIntent.getActivity(context, PendingIntent.FLAG_ONE_SHOT,
                            new Intent(context, completedActivity), 0), // Complete
                    PendingIntent.getActivity(context, PendingIntent.FLAG_ONE_SHOT,
                            new Intent(context, canceledActivity), 0)); // Canceled
            authService.dispose();
        } );
    }

    /**
     * <p>Calls the {@link Activity#onActivityResult} method of the {@code activity} passed in,
     * when done.  Test for the correct {@code requestCode} value, before processing.</p>
     * <p>Use {@link AuthorizationResponse#fromIntent(Intent)} and
     * {@link AuthorizationException#fromIntent(Intent)} in your processing, to determine if the
     * authorization was successful or not.</p>
     *
     * @param activity
     * @param requestCode
     */
    synchronized static public void performAuthRequest(final Activity activity,
                                                       final int requestCode) {

        AppExecutors.$().netIO().execute(() -> {
            // https://github.com/openid/AppAuth-Android/blob/master/README.md
            final AuthorizationService authService =  new AuthorizationService(activity);
            final AuthorizationRequest authRequest = getAuthRequest(activity);
            Intent authIntent = authService.getAuthorizationRequestIntent(authRequest);
            activity.startActivityForResult(authIntent, requestCode);
            authService.dispose();
        } );
    }

    // Should not be called directly!
    static private AuthorizationRequest getAuthRequest(final Context context) {
        // https://progur.com/2016/10/how-to-use-reddit-oauth2-in-android-apps.html
        // https://github.com/openid/AppAuth-Android/blob/master/README.md

        final String urlAuth = URL_BASE + "/api/v1/authorize.compact";
        final Uri uriAuth = Uri.parse(urlAuth);

        final String urlToken = URL_BASE + "/api/v1/access_token";
        final Uri uriToken = Uri.parse(urlToken);

        ///////////////////////////////////////////////////////////////////////////////////////
        // First, AppAuth must be instructed how to interact with the authorization service ...
        AuthorizationServiceConfiguration serviceConfig =
                new AuthorizationServiceConfiguration(uriAuth, uriToken);
        Log.d(TAG, "getAuthRequest: serviceConfig: " + serviceConfig);

        // Create the AuthState, persisting the configuration ...
        AuthStateManager.$(context).replace(new AuthState(serviceConfig));

        ////////////////////////////////////////////////////////////////////////////////////////
        // An authorization code can now be acquired by constructing an AuthorizationRequest ...
        // @formatter:off
        AuthorizationRequest.Builder authRequestBuilder =
                new AuthorizationRequest.Builder(
                        // the authorization service configuration ...
                        serviceConfig,
                        // the client ID, typically pre-registered and static ...
                        BuildConfig.Reddit_Client_Id_Capstone,
                        // the response_type value: we want a code ...
                        ResponseTypeValues.CODE,
                        // the redirect URI to which the auth response is sent ...
                        Uri.parse("http://romanelli.info/capstone/redirect")
                )
                .setScope("identity mysubreddits read") // https://github.com/reddit-archive/reddit/wiki/OAuth2
                .setState(RedditAuthManager.STATE)
                .setAdditionalParameters(
                        Stream.of(
                                new AbstractMap.SimpleEntry<>("duration", "permanent")
                        )
                        .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue))
                );
        // @formatter:on
        if (BuildConfig.DEBUG) Log.d(TAG, "getAuthRequest: authRequestBuilder: " + authRequestBuilder);

        //////////////////////////////////////////////////////////
        // Have the builder construct the AuthorizationRequest ...
        AuthorizationRequest authRequest = authRequestBuilder.build();
        Log.d(TAG, "getAuthRequest: authRequest: " + authRequest.toUri());

        return authRequest;
    }

    /**
     * <p>Calls {@link AuthStateManager#updateAfterAuthorization(AuthorizationResponse, AuthorizationException)},
     * then, if a successful auth response carrying an auth code was received, do a token
     * request can be made to exchange the code for a refresh token.</p>
     * @param resp
     * @param excp
     */
    static public void performTokenRequest(final Context context,
                                           final AuthorizationResponse resp,
                                           final AuthorizationException excp,
                                           final AuthState.AuthStateAction actionAuthState) {

        AuthStateManager.$(context).updateAfterAuthorization(resp, excp);
        // Check the results of the auth request ...
        if (resp != null) {
            // Given a successful authorization response carrying an authorization code,
            // a token request can be made to exchange the code for a refresh token.
            Log.d(TAG, "performTokenRequest: isAuthorized? " + isAuthorized(context));
            final AuthorizationService authService = new AuthorizationService(context);
            AppExecutors.$().netIO().execute(() -> authService.performTokenRequest(
                    resp.createTokenExchangeRequest(),
                    new ClientSecretBasic(
                            BuildConfig.Reddit_Client_Secret_Capstone
                    ),
                    (tr, ae) -> {
                        AuthStateManager.$(context).updateAfterTokenResponse(tr, ae);
                        if (ae != null) {
                            // Obtain token failed
                            Log.e(TAG, "performTokenRequest: Auth failed! [" + ae.error + "][" + ae.errorDescription + "]", ae);
                            actionAuthState.execute(null, null, ae);
                        }
                        else {
                            // Obtain token did somethin' ???
                            Log.w(TAG, "performTokenRequest: Did not expect to get there!" );
                            actionAuthState.execute(null, null, null);
                        }
                        authService.dispose();
                    }
            ));
        } else if (excp != null) {
            Log.e(TAG, "onActivityResult: Authenticate failure! ", excp);
            actionAuthState.execute(null, null, excp);
        } else {
            // TODO Better to just throw an IllegalArgumentException ?
            Log.w(TAG, "performTokenRequest: No auth state received - reauth required!");
            AuthorizationException ae = new AuthorizationException(
                    AuthorizationException.TYPE_OAUTH_AUTHORIZATION_ERROR,
                    AuthorizationException.AuthorizationRequestErrors.OTHER.code,
                    "No Auth Response/Exception Received",
                    "Expected to receiver either/or AuthorizationResponse/AuthorizationException",
                    null,
                    null
            );
            actionAuthState.execute(null, null, ae);
        }
    }

    /**
     * <p>Calls {@link AuthState.AuthStateAction#execute(String, String, AuthorizationException)}
     * after attempting to refresh the token.  You should do your net call upon successful token refresh, determined
     * via the fact that {@link AuthorizationException} returned value is {@code null}.</p>
     * @param context Will be used to obtain the application {@link Context} via a call to
     *                {@link Context#getApplicationContext()}.
     * @param actionAuthState Will have its {@link AuthState.AuthStateAction#execute(String, String, AuthorizationException)}
     *                        method called after attempting/succeeding to get a refresh token from the server.
     */
    static public void performActionWithFreshTokens(final Context context,
                                                    final AuthState.AuthStateAction actionAuthState) {
        AppExecutors.$().netIO().execute(() -> {
            Log.d(TAG, "performActionWithFreshTokens: isAuthorized? " + isAuthorized(context));
            AuthorizationService authService = null;
            try {
                authService = new AuthorizationService(context);
                AuthStateManager.$(context).getAuthState().performActionWithFreshTokens(
                        authService,
                        new ClientSecretBasic( BuildConfig.Reddit_Client_Secret_Capstone ),
                        actionAuthState
                );
            }
            finally {
                if (authService != null) {
                    // ClientSecretBasic can throw NPE
                    authService.dispose();
                }
            }
        });
    }

}
