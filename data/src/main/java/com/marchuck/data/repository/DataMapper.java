package com.marchuck.data.repository;

import com.marchuck.NetworkResponse;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public class DataMapper {

    @Inject DataMapper() {
    }

    public NetworkResponse transform(ResponseBody responseBody) {
        try {
            return new NetworkResponse(responseBody.string());
        } catch (IOException e) {
            return new NetworkResponse(null);
        }
    }
}
