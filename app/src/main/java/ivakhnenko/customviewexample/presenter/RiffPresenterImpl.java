package ivakhnenko.customviewexample.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ivakhnenko.customviewexample.network.UserFactoryImpl;
import ivakhnenko.customviewexample.view.UsersListView;
import ivakhnenko.customviewexample.viewmodel.RiffListModel;
import ivakhnenko.customviewexample.viewmodel.RiffListModelImpl;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public class RiffPresenterImpl implements RiffListPresenter {

    private RiffListModel model;

    private UsersListView userView;

    public RiffPresenterImpl() {
        this.model = new RiffListModelImpl(new UserFactoryImpl());
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume(UsersListView view) {
        this.userView = view;
        userView.showWaiting();
        model.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(users -> {
                userView.hideWaiting();
                userView.setUsers(users);
                });

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        userView = null;
    }
}
