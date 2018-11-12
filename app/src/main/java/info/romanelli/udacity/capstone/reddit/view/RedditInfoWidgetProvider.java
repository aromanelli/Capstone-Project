package info.romanelli.udacity.capstone.reddit.view;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.text.NumberFormat;

import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.DataRepository;

/**
 * Implementation of App Widget functionality.
 */
public class RedditInfoWidgetProvider extends AppWidgetProvider {

    public static final String TAG = RedditInfoWidgetProvider.class.getSimpleName();

    public static final String EXTRA_INFO_SUBREDDIT =
            RedditInfoWidgetProvider.class.getPackage().getName() + ":info:widget:subreddit";

    static final NumberFormat FORMATTER = NumberFormat.getIntegerInstance();

    private static RemoteViews getSmallRemoteView(final Context context) {
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.reddit_info_widget_small);

        views.setTextViewText(
                R.id.appwidget_newposts_counter,
                String.valueOf(FORMATTER.format(DataRepository.$(context).sizeNewPosts()))
        );

        // This Intent is for when the user clicks on total posts count in the widget,
        // to launch the main activity and pass that selection to it ...
        Intent clickIntent = new Intent(context, NewPostsListActivity.class);
        PendingIntent clickPI = PendingIntent
                .getActivity(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.appwidget_newposts_counter, clickPI);

        return views;
    }

    private static RemoteViews getNormalRemoteView(final Context context, final int appWidgetId) {
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.reddit_info_widget_normal);

        Intent svcIntent = new Intent(context, RedditInfoWidgetRemoteViewService.class);
        svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));

        views.setRemoteAdapter(R.id.appwidget_newposts_list, svcIntent);

        // This Intent is for when the user clicks on a subreddit info in the widget,
        // to launch the main activity and pass that selection to it ...
        Intent clickIntent = new Intent(context, NewPostsListActivity.class);
        PendingIntent clickPI = PendingIntent
                .getActivity(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setPendingIntentTemplate(R.id.appwidget_newposts_list, clickPI);

        return views;
    }

    @Override
    public void onUpdate(Context context,
                         AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {

            Bundle options = appWidgetManager.getAppWidgetOptions(appWidgetId);
            int minWidth = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
            int minHeight = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);

            RemoteViews views;
            // https://developer.android.com/guide/practices/ui_guidelines/widget_design#anatomy_determining_size
            if ((minWidth >= 200) && (minHeight >= 130)) {
                views = getNormalRemoteView(context, appWidgetId);
            } else {
                views = getSmallRemoteView(context);
            }

            /////////////////////////////////////////////////////
            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);

        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    // Receives the broadcast ...
    @Override
    public void onReceive(Context context, Intent intent) {
        // See DataRepository.broadcastToWidgets
        // We're not passing any extra data to this widget, so carry on ...
        super.onReceive(context, intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager,
                                          int appWidgetId, Bundle newOptions) {
        // Called in response to the AppWidgetManager.ACTION_APPWIDGET_OPTIONS_CHANGED
        // broadcast when this widget has been layed out at a new size.
        onUpdate(context, appWidgetManager, new int[] {appWidgetId});
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

//    @Override
//    public void onEnabled(Context context) {
//        // Enter relevant functionality for when the first widget is created
//    }

//    @Override
//    public void onDisabled(Context context) {
//        // Enter relevant functionality for when the last widget is disabled
//    }

//    @Override
//    public void onDeleted(Context context, int[] appWidgetIds) {
//        // Perform any action when one or more AppWidget instances have been deleted
//    }

}

