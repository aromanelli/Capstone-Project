package info.romanelli.udacity.capstone.reddit.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import info.romanelli.udacity.capstone.reddit.data.DataRepository;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;

class NewPostsViewModel extends AndroidViewModel {

    final static private String TAG = NewPostsViewModel.class.getSimpleName();

    private LiveData<List<NewPostEntity>> mNewPosts;
    private boolean mIsRefreshing = false;

    NewPostsViewModel(@NonNull Application application) {
        super(application);
        mNewPosts = DataRepository.$(application).getNewPosts();
    }

    LiveData<List<NewPostEntity>> getNewPosts() {
        return mNewPosts;
    }
    
    boolean isRefreshing() {
        return mIsRefreshing;
    }

    void setIsRefreshing(final boolean refreshing) {
        this.mIsRefreshing = refreshing;
    }

}
