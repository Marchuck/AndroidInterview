package com.marchuck.androidinterview;

import com.marchuck.DataProvider;
import com.marchuck.NetworkResponse;
import com.marchuck.androidinterview.presenter.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private DataProvider provider;

    @Inject MainPresenter(DataProvider provider) {
        this.provider = provider;
    }

    public void requestData() {
        provider.provide()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override public void accept(Disposable disposable) throws Exception {
                        disposables.add(disposable);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NetworkResponse>() {
                    @Override public void accept(NetworkResponse response) throws Exception {
                        view.onResponse(response);
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) throws Exception {
                        view.showError("kurwens, error");
                    }
                });
    }


    @Override public void resume() {

    }

    @Override public void pause() {

    }
}
