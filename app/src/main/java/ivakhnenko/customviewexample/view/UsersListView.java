package ivakhnenko.customviewexample.view;

import java.util.List;

import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public interface UsersListView {

    void setUsers(List<User> users);

    void showWaiting();

    void hideWaiting();

    void onUserClick(User user);

}
