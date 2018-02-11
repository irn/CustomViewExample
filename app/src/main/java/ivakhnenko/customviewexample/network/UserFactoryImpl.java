package ivakhnenko.customviewexample.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;

import io.reactivex.Observable;
import ivakhnenko.customviewexample.model.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ruslan Ivakhnenko on 10.02.18.
 */

public class UserFactoryImpl implements UserFactory {

    private Retrofit retrofit;

    private IUserApi riffApi;

    public UserFactoryImpl(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://riffexample.firebaseio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        riffApi = retrofit.create(IUserApi.class);
    }
    @Override
    public Observable<Map<String, User>> getUsers() {
        return riffApi.getUsers();
    }
}
