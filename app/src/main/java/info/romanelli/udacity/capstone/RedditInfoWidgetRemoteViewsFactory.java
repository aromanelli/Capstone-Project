package info.romanelli.udacity.capstone;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.List;

import info.romanelli.udacity.capstone.reddit.data.DataRepository;

public class RedditInfoWidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context context;
    private int appWidgetId;
    private List<DataRepository.SubredditInfo> subredditInfo;

    RedditInfoWidgetRemoteViewsFactory(Context applicationContext, Intent intent) {
        context = applicationContext;
        appWidgetId = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID );
        subredditInfo = DataRepository.$(context).getSubredditsInfo();
    }

    @Override
    public void onCreate() {
        // NO-OP
    }

    @Override
    public void onDataSetChanged() {
        // NO-OP
    }

    @Override
    public void onDestroy() {
        // NO-OP
    }

    @Override
    public int getCount() {
        return subredditInfo.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {

        RemoteViews row = new RemoteViews(
                context.getPackageName(),R.layout.reddit_info_widget_normal_listrow );

        String nameSubreddit = subredditInfo.get(position).getPrefixedSubreddit();
        long numberOfPosts = subredditInfo.get(position).getSizeNewposts();
        final StringBuilder builder = new StringBuilder();
        builder.append(nameSubreddit);
        builder.append(": ");
        builder.append(RedditInfoWidgetProvider.FORMATTER.format(numberOfPosts));
        builder.append(" post");
        if (numberOfPosts != 1) {
            builder.append('s');
        }

        row.setTextViewText(android.R.id.text1, builder.toString() );

        // This Intent is for when the user clicks on a subreddit info in the widget,
        // to launch the main activity and pass that selection to it ...
        Intent i = new Intent();
        Bundle extras = new Bundle();
        extras.putString(
                RedditInfoWidgetProvider.EXTRA_INFO_SUBREDDIT,
                nameSubreddit );
        i.putExtras(extras);
        row.setOnClickFillInIntent(android.R.id.text1, i);

        return(row);
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
