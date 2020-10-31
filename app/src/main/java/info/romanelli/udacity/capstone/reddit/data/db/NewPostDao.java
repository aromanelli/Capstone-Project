package info.romanelli.udacity.capstone.reddit.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NewPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NewPostEntity newPostEntity);

    @Query("SELECT * from new_posts ORDER BY created DESC")
    LiveData<List<NewPostEntity>> getNewPosts();

    @Query("DELETE FROM new_posts")
    void deleteAllNewPosts();

    @Query("DELETE FROM new_posts WHERE created < :pruneThresholdDate")
    void pruneNewPosts(long pruneThresholdDate);

}
