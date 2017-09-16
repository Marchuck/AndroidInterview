package com.marchuck.androidinterview.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lukasz.marczak on 06/09/2017.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
