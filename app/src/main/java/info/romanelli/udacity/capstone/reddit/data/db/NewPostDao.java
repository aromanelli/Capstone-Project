package info.romanelli.udacity.capstone.reddit.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NewPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NewPostEntity newPostEntity);

    @Query("SELECT * from new_posts ORDER BY created DESC")
    LiveData<List<NewPostEntity>> getNewPosts();

//    @Query("SELECT DISTINCT subreddit_name, count(*) " +
//            "from new_posts " +
//            "GROUP BY subreddit_name " +
//            "ORDER BY subreddit_name ASC")
//    LiveData<List<NewPostEntity>> getSubreddits();

    @Query("DELETE FROM new_posts")
    void deleteNewPosts();

}
