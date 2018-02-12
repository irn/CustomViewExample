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
                view.hideWaiting();
                view.setUsers(users);
                });

    }

    @Override
    public void onPause() {

    }
}
