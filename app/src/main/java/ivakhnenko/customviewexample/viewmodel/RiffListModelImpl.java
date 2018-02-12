package ivakhnenko.customviewexample.viewmodel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import ivakhnenko.customviewexample.database.UserDatabaseFactory;
import ivakhnenko.customviewexample.database.UserDatabaseFactoryImpl;
import ivakhnenko.customviewexample.model.User;
import ivakhnenko.customviewexample.network.UserFactory;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public class RiffListModelImpl implements RiffListModel {

    private UserFactory userFactory;

    private UserDatabaseFactory databaseFactory;

    public RiffListModelImpl(UserFactory userFactory) {
        this.userFactory = userFactory;
        databaseFactory = new UserDatabaseFactoryImpl(MyApplication.getContext());
    }

    @Override
    public Observable<List<User>> getUsers() {

        return userFactory.getUsers()
                .subscribeOn(Schedulers.io())
                .map(map -> {
                    for (User u : map.values()) {
                        databaseFactory.insert(u);
                    }
                    return databaseFactory.getUsers();

                });

    }

}
