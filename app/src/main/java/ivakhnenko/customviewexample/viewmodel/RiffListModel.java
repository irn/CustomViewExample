package ivakhnenko.customviewexample.viewmodel;

import java.util.Map;

import io.reactivex.Observable;
import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 11.02.18.
 */

public interface RiffListModel {

    Observable<Map<String,User>> getUsers();
}
