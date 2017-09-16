package com.marchuck.androidinterview.di.components;

import com.marchuck.androidinterview.MainActivity;
import com.marchuck.androidinterview.di.ActivityScope;
import com.marchuck.androidinterview.di.modules.ActivityModule;

import dagger.Subcomponent;

/**
 * Created by lukasz.marczak on 06/09/2017.
 */
@ActivityScope @Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
