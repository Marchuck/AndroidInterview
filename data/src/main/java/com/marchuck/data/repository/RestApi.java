package com.marchuck.data.repository;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public interface RestApi {
    @Streaming
    @GET Observable<ResponseBody> requestData();

}
