package ivakhnenko.customviewexample.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 12.02.18.
 */

public class UserDatabaseFactoryImpl implements UserDatabaseFactory {

    private UserAppDatabase database;

    public UserDatabaseFactoryImpl(Context context) {
        database = Room.databaseBuilder(context, UserAppDatabase.class, "database-user").build();
    }

    @Override
    public List<User> getUsers() {
        return database.userDao().findAll();
    }

    @Override
    public void insertUsers(User... users) {
        database.userDao().insertAll(users);
    }

    @Override
    public void insert(User user) {
        database.userDao().insert(user);
    }
}
