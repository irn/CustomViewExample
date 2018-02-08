package ivakhnenko.customviewexample.database;

import java.util.List;

import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 08.02.18.
 */

public interface IDatabaseAdapter {

    void addUser(User user);

    List<User> getUsers();

    User findUserById(Integer id);
}
