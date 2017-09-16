package com.marchuck.androidinterview.di.modules;

import android.support.v4.app.FragmentActivity;
import android.widget.ProgressBar;

import com.marchuck.ProgressListener;
import com.marchuck.androidinterview.MainActivity;
import com.marchuck.androidinterview.ProgressListenerImpl;
import com.marchuck.androidinterview.di.ActivityScope;
import com.marchuck.androidinterview.di.HasComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lukasz.marczak on 06/09/2017.
 */
@Module
public class ActivityModule {

    private final FragmentActivity activity;

    public ActivityModule(FragmentActivity activity) {
        this.activity = activity;
    }


    @Provides @ActivityScope FragmentActivity FragmentActivity() {
        return this.activity;
    }

    @Provides  ProgressListener ProgressListener(ProgressListenerImpl impl) {
        return impl;
    }

    @Provides @ActivityScope HasComponent<ProgressBar> HasComponentprogressBar(MainActivity impl) {
        return impl;
    }

    @Provides @ActivityScope MainActivity MainActivity() {
        if (activity instanceof MainActivity) return (MainActivity) activity;
        return null;
    }
}
