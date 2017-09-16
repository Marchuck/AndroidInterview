package com.marchuck.androidinterview.di.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.marchuck.DataProvider;
import com.marchuck.androidinterview.App;
import com.marchuck.data.repository.CacheManager;
import com.marchuck.data.repository.CacheManagerImpl;
import com.marchuck.data.repository.DataProviderImpl;
import com.marchuck.data.repository.RestApi;
import com.marchuck.data.repository.RestApiImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lukasz.marczak on 06/09/2017.
 */
@Module
public class AppModule {

    private final App context;

    public AppModule(App context) {
        this.context = context;
    }

    @Provides @Singleton DataProvider dataProvider(DataProviderImpl x) {
        return x;
    }

    @Provides @Singleton CacheManager<String, String> CacheManager(CacheManagerImpl x) {
        return x;
    }

    @Provides @Singleton SharedPreferences sharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides RestApi restApi(RestApiImpl o) {
        return o;
    }

}
