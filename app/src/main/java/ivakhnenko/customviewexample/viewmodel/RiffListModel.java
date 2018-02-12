package ivakhnenko.customviewexample.viewmodel;

import java.util.List;

import io.reactivex.Observable;
import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public interface RiffListModel {

    Observable<List<User>> getUsers();
}
