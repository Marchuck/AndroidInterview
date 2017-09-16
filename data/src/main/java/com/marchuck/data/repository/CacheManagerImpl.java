package com.marchuck.data.repository;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public class CacheManagerImpl implements CacheManager<String, String> {

    private SharedPreferences sharedPreferences;

    @Inject public CacheManagerImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override public void put(String key, String networkResponse) {
        sharedPreferences.edit().putString(key, networkResponse).apply();
    }

    @Override public String get(String key) {
        return sharedPreferences.getString(key, null);
    }
}
