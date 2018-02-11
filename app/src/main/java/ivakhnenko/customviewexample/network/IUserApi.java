package ivakhnenko.customviewexample.network;

import java.util.Map;

import io.reactivex.Observable;
import ivakhnenko.customviewexample.model.User;
import retrofit2.http.GET;

/**
 * Created by Ruslan Ivakhnenko on 10.02.18.
 */

public interface IUserApi {

    @GET("ruslan/riffusers.json")
    Observable<Map<String,User>> getUsers();
}
