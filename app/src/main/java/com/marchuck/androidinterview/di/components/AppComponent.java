package com.marchuck.androidinterview.di.components;

import com.marchuck.androidinterview.di.modules.ActivityModule;
import com.marchuck.androidinterview.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by lukasz.marczak on 06/09/2017.
 */
@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
    
    ActivityComponent plus(ActivityModule module);
}
