package ivakhnenko.customviewexample.presenter;

import ivakhnenko.customviewexample.view.UsersListView;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public interface RiffListPresenter {

    void onCreate();

    void onResume(UsersListView view);

    void onPause();

    void onDestroy();
}
