package com.marchuck.data.repository;

import com.marchuck.DataProvider;
import com.marchuck.NetworkResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public class DataProviderImpl implements DataProvider {

    private RestApi restApi;
    private DataMapper mapper;
    private CacheManager<String, String> cacheManager;

    @Inject public DataProviderImpl(RestApi api,
                                    DataMapper mapper,
                                    CacheManager<String, String> manager) {
        this.restApi = api;
        this.mapper = mapper;
        this.cacheManager = manager;
    }

    @Override public Observable<NetworkResponse> provide() {
        return restApi.requestData()
                .map(new Function<ResponseBody, NetworkResponse>() {
                    @Override
                    public NetworkResponse apply(
                            @NonNull ResponseBody responseBody) throws Exception {
                        return mapper.transform(responseBody);
                    }
                }).doOnNext(new Consumer<NetworkResponse>() {
                    @Override public void accept(NetworkResponse networkResponse) throws Exception {
                        if (networkResponse.isSuccessful()) {
                            cacheManager.put("", networkResponse.getResponse());
                        }
                    }
                }).onErrorReturn(new Function<Throwable, NetworkResponse>() {
                    @Override
                    public NetworkResponse apply(@NonNull Throwable throwable) throws Exception {
                        return new NetworkResponse(cacheManager.get(""));
                    }
                });
    }
}
