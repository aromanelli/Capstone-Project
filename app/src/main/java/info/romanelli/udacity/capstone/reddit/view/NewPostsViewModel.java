package info.romanelli.udacity.capstone.reddit.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

class NewPostsViewModel extends AndroidViewModel {

    final static private String TAG = NewPostsViewModel.class.getSimpleName();

    private boolean mIsRefreshing = false;

    NewPostsViewModel(@NonNull Application application) {
        super(application);
    }

    boolean isRefreshing() {
        return mIsRefreshing;
    }

    void setIsRefreshing(final boolean refreshing) {
        this.mIsRefreshing = refreshing;
    }

}
