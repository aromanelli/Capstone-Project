package info.romanelli.udacity.capstone.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import info.romanelli.udacity.capstone.BuildConfig;
import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.net.RedditDataService;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;

public class FirebaseAnalyticsManager {

    private static final String TAG = FirebaseAnalyticsManager.class.getSimpleName();

    private static volatile FirebaseAnalyticsManager INSTANCE;

    public static FirebaseAnalyticsManager $(final Context context) {
        if (INSTANCE == null) {
            synchronized (FirebaseAnalyticsManager.class) {
                if (INSTANCE == null) {
                    Log.d(TAG, "$: Creating FirebaseAnalyticsManager instance");
                    INSTANCE = new FirebaseAnalyticsManager(context);
                }
            }
        }
        return INSTANCE;
    }

    public static final String ANALYTICS_ITEM_ID_AUTH_STARTED = "AUTH_STARTED";
    public static final String ANALYTICS_ITEM_ID_AUTH_ENDED = "AUTH_ENDED";
    public static final String ANALYTICS_ITEM_ID_FETCHED_NEW_POSTS = "FETCHED_NEW_POSTS";
    public static final String ANALYTICS_ITEM_ID_VIEW_NEW_POST = "VIEW_NEW_POST";

    // https://firebase.google.com/docs/crashlytics/upgrade-sdk?platform=android
    private final FirebaseAnalytics mFirebaseAnalytics;
    private final FirebaseCrashlytics mFirebaseCrashlytics;

    private FirebaseAnalyticsManager(final Context context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context.getApplicationContext());
        mFirebaseCrashlytics = FirebaseCrashlytics.getInstance();
    }

    public void logEventRedditAuthStarted() {
        logEvent(RedditAuthManager.class.getSimpleName(),
                ANALYTICS_ITEM_ID_AUTH_STARTED,
                null,
                true,
                FirebaseAnalytics.Event.LOGIN
        );
    }

    public void logEventRedditAuthEnded(final boolean success) {
        logEvent(RedditAuthManager.class.getSimpleName(),
                ANALYTICS_ITEM_ID_AUTH_ENDED,
                null,
                success,
                FirebaseAnalytics.Event.LOGIN
        );
    }

    public void logEventFetchedNewPosts(boolean success) {
        logEvent(RedditDataService.class.getSimpleName(),
                ANALYTICS_ITEM_ID_FETCHED_NEW_POSTS,
                null,
                success,
                FirebaseAnalytics.Event.SEARCH
        );
    }

    public void logEventViewNewPost(final NewPostEntity item) {
        logEvent(NewPostEntity.class.getSimpleName(),
                ANALYTICS_ITEM_ID_VIEW_NEW_POST,
                item.getId(),
                true,
                FirebaseAnalytics.Event.VIEW_ITEM
        );
    }

    private void logEvent(final String itemName,
                          final String itemCategory,
                          final String itemId,
                          final boolean success,
                          final String eventType) {

        Bundle bundle = new Bundle();

        Assert.that(itemName != null);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, itemName);

        Assert.that(itemCategory != null);
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, itemCategory);

        if (itemId != null && itemId.trim().length() >= 1) {
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, itemId);
        }

        bundle.putLong(FirebaseAnalytics.Param.SUCCESS, success ? 1L : 0L);

        // https://firebase.google.com/docs/reference/android/com/google/firebase/analytics/FirebaseAnalytics.Event#constants
        mFirebaseAnalytics.logEvent(eventType, bundle);
    }

    public void addCrashButton(final Activity activity) {

        if (!BuildConfig.DEBUG) {
            Log.i(TAG, "addCrashButton: Not in 'debug' build/mode, so will not add crash button!");
            return;
        }

        // Create button ...
        Button crashButton = new Button(activity);
        crashButton.setBackgroundColor(
                activity.getResources().getColor(
                        R.color.colorErrorBack, activity.getTheme()));
        crashButton.setTextColor(
                activity.getResources().getColor(
                        R.color.colorErrorText, activity.getTheme()));
        crashButton.setText(activity.getString(R.string.crash));
        crashButton.setOnClickListener(view -> {
            // mFirebaseCrashlytics.getInstance().crash(); // Force a crash NO LONGER EXISTS!
            // https://firebase.google.com/docs/crashlytics/upgrade-sdk?platform=android
            throw new UnsupportedOperationException(
                    "Crashing on purpose because the crash button was pressed!");
        });
        // layout ...
        LinearLayout layout = new LinearLayout(activity.getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_VERTICAL|Gravity.END);
        LinearLayout.LayoutParams viewParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT );
        layout.addView(crashButton, viewParams);
        // layoutParams ...
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT );
        // Add to Activity ...
        activity.addContentView(layout, layoutParams);
    }

}
