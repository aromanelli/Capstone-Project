package info.romanelli.udacity.capstone.reddit.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NewPostEntity.class}, version = 1)
public abstract class NewPostDatabase extends RoomDatabase {

    private static volatile NewPostDatabase INSTANCE;

    public static NewPostDatabase $(final Context context) {
        if (INSTANCE == null) {
            synchronized (NewPostDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            NewPostDatabase.class, "new_post_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract NewPostDao daoNewPost();
}
