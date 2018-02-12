package ivakhnenko.customviewexample.viewmodel;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ruslan Ivakhnenko on 12.02.18.
 */

public class MyApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext(){
        return sContext;
    }
}
