package info.romanelli.udacity.capstone.reddit.view;

import android.arch.lifecycle.ViewModel;

class NewPostsViewModel extends ViewModel {

    private static final String TAG = NewPostsViewModel.class.getSimpleName();

    private boolean mIsRefreshing = false;

    public NewPostsViewModel() {
        super();
    }

    boolean isRefreshing() {
        return mIsRefreshing;
    }

    void setIsRefreshing(final boolean refreshing) {
        this.mIsRefreshing = refreshing;
    }

}
