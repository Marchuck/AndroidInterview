package com.marchuck.androidinterview.presenter;

import android.support.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public abstract class BasePresenter<View> {

    protected View view;

    protected CompositeDisposable disposables = new CompositeDisposable();

    public void setView(View view) {
        this.view = view;
    }

    public abstract void resume();

    public abstract void pause();

    @CallSuper
    public void destroy() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

}
