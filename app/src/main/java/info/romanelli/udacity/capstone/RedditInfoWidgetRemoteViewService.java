package info.romanelli.udacity.capstone;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class RedditInfoWidgetRemoteViewService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RedditInfoWidgetRemoteViewsFactory(getApplicationContext(), intent);
    }
}
