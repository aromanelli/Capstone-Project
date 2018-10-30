package info.romanelli.udacity.capstone.reddit.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
