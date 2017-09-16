package com.marchuck.androidinterview;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.marchuck.androidinterview.di.components.ActivityComponent;
import com.marchuck.androidinterview.di.components.AppComponent;
import com.marchuck.androidinterview.di.modules.ActivityModule;
import com.marchuck.androidinterview.di.modules.AppModule;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public class App extends Application {

    AppComponent appComponent;


    @Override public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    public ActivityComponent createActivityComponent(FragmentActivity fragmentActivity) {
        return getAppComponent().plus(new ActivityModule(fragmentActivity));
    }
}
