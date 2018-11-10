package info.romanelli.udacity.capstone;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.text.NumberFormat;
import java.util.Set;

import info.romanelli.udacity.capstone.reddit.data.DataRepository;

/**
 * Implementation of App Widget functionality.
 */
public class RedditInfoWidget extends AppWidgetProvider {

    public static final String TAG = RedditInfoWidget.class.getSimpleName();

    private static final NumberFormat FORMATTER = NumberFormat.getIntegerInstance();

    private static RemoteViews getSmallRemoteView(final Context context) {
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.reddit_info_widget_small);

        views.setTextViewText(
                R.id.appwidget_newposts_counter,
                String.valueOf(FORMATTER.format(DataRepository.$(context).sizeNewPosts()))
        );

        return views;
    }

    private static RemoteViews getNormalRemoteView(final Context context) {
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.reddit_info_widget_normal);

        Set<DataRepository.SubredditInfo> setSubreddits =
                DataRepository.$(context).getSubredditsInfo();
        if (setSubreddits.size() >= 1) {
            final StringBuilder builder = new StringBuilder();
            setSubreddits.forEach(subredditInfo -> {
                builder.append(subredditInfo.getPrefixedSubreddit());
                builder.append(": ");
                builder.append(FORMATTER.format(subredditInfo.getSizeNewposts()));
                builder.append('\n');
            });
            views.setTextViewText(R.id.appwidget_newposts_list, builder.toString());
        } else {
            views.setTextViewText(R.id.appwidget_newposts_list, "");
        }

        return views;
    }

    @Override
    public void onUpdate(Context context,
                         AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    // Called by onUpdate(...), for each widget ...
    static void updateAppWidget(Context context,
                                AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Bundle options = appWidgetManager.getAppWidgetOptions(appWidgetId);
        int minWidth = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
        int minHeight = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);

        RemoteViews views;
        // https://developer.android.com/guide/practices/ui_guidelines/widget_design#anatomy_determining_size
        if (minHeight < 110 || minWidth < 180) {
            views = getSmallRemoteView(context);
        } else {
            views = getNormalRemoteView(context);
        }

        /////////////////////////////////////////////////////
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
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
        updateAppWidget(context, appWidgetManager, appWidgetId);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

//    @Override
//    public void onDeleted(Context context, int[] appWidgetIds) {
//        // Perform any action when one or more AppWidget instances have been deleted
//    }

//    @Override
//    public void onEnabled(Context context) {
//        // Enter relevant functionality for when the first widget is created
//    }

//    @Override
//    public void onDisabled(Context context) {
//        // Enter relevant functionality for when the last widget is disabled
//    }

}

