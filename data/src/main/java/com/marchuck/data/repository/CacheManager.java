package com.marchuck.data.repository;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public interface CacheManager<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);


}
