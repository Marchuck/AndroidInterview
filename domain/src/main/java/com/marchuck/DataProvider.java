package com.marchuck;

import io.reactivex.Observable;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public interface DataProvider {


    Observable<NetworkResponse> provide();
}
