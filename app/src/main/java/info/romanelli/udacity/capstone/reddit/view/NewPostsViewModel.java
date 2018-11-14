package info.romanelli.udacity.capstone.reddit.view;

import android.arch.lifecycle.ViewModel;

public class NewPostsViewModel extends ViewModel {

    private static final String TAG = NewPostsViewModel.class.getSimpleName();

    private boolean mIsRefreshing = false;

    private int mIndexVisiblePos = Integer.MIN_VALUE;

    public NewPostsViewModel() {
        super();
    }

    boolean isRefreshing() {
        return mIsRefreshing;
    }

    void setIsRefreshing(final boolean refreshing) {
        this.mIsRefreshing = refreshing;
    }

    public int getIndexVisiblePos() {
        return mIndexVisiblePos;
    }

    public void setIndexVisiblePos(int indexVisiblePos) {
        this.mIndexVisiblePos = indexVisiblePos;
    }

}
