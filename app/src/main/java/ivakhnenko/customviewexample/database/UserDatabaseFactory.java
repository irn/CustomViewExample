package ivakhnenko.customviewexample.database;

import java.util.List;

import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 12.02.18.
 */

public interface UserDatabaseFactory {

    List<User> getUsers();

    void insertUsers(User... users);

    void insert(User user);
}
