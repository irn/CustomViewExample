package ivakhnenko.customviewexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 12.02.18.
 */

@Database(entities = {User.class}, version = 1)
public abstract class UserAppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
