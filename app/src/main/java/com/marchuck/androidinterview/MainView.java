package com.marchuck.androidinterview;

import com.marchuck.NetworkResponse;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public interface MainView {

    void onResponse(NetworkResponse response);

    void showError(String message);
}
