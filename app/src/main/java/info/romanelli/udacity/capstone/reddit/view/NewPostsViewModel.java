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

    private LiveData<List<NewPostEntity>> ldNewPosts;

    NewPostsViewModel(@NonNull Application application) {
        super(application);
        ldNewPosts = DataRepository.$(application).getNewPosts();
    }

    LiveData<List<NewPostEntity>> getNewPosts() {
        return ldNewPosts;
    }

}
