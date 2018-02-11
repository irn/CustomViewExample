package ivakhnenko.customviewexample.viewmodel;

import java.util.Map;

import io.reactivex.Observable;
import ivakhnenko.customviewexample.model.User;
import ivakhnenko.customviewexample.network.UserFactory;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public class RiffListModelImpl implements RiffListModel {

    private UserFactory userFactory;

    public RiffListModelImpl(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Override
    public Observable<Map<String, User>> getUsers() {
        return userFactory.getUsers();
    }
}
