package ivakhnenko.customviewexample.network;

import java.util.Map;

import io.reactivex.Observable;
import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 10.02.18.
 */

public interface UserFactory {

    public Observable<Map<String, User>> getUsers();

}
