package ivakhnenko.customviewexample.presenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ivakhnenko.customviewexample.model.User;
import ivakhnenko.customviewexample.network.UserFactoryImpl;
import ivakhnenko.customviewexample.view.UsersListView;
import ivakhnenko.customviewexample.viewmodel.RiffListModel;
import ivakhnenko.customviewexample.viewmodel.RiffListModelImpl;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public class RiffPresenterImpl implements RiffListPresenter {

    private RiffListModel model;

    private UsersListView view;

    public RiffPresenterImpl(UsersListView view) {
        this.model = new RiffListModelImpl(new UserFactoryImpl());
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        view.showWaiting();
        model.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(users -> {
                List<User> userList = new ArrayList<>();
                for( User u : users.values()){
                    userList.add(u);
                }
                view.hideWaiting();
                view.setUsers(userList);
                });

    }

    @Override
    public void onPause() {

    }
}
