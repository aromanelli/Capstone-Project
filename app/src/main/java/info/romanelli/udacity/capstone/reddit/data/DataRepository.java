package info.romanelli.udacity.capstone.reddit.data;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

import info.romanelli.udacity.capstone.reddit.data.db.NewPostDao;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostDatabase;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.util.AppExecutors;

public class DataRepository {

    private NewPostDao daoNewPost;
    private LiveData<List<NewPostEntity>> ldNewPosts;

    public DataRepository(final Context context) {
        NewPostDatabase db = NewPostDatabase.$(context.getApplicationContext());
        daoNewPost = db.daoNewPost();
        ldNewPosts = daoNewPost.getNewPosts();
    }

    public LiveData<List<NewPostEntity>> getNewPosts() {
        return ldNewPosts;
    }

    public void addNewPost(final NewPostEntity newPostEntity) {
        AppExecutors.$().diskIO().execute(() -> daoNewPost.insert(newPostEntity));
    }

    public void deleteNewPosts() {
        AppExecutors.$().diskIO().execute(() -> daoNewPost.deleteNewPosts());
    }

}
