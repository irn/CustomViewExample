package ivakhnenko.customviewexample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 12.02.18.
 */

@Dao
public interface UserDao {

    @Query("select * from User")
    List<User> findAll();

    @Insert
    void insertAll(User... users);

    @Update
    void insert(User user);
}
