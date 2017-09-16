package com.marchuck.androidinterview;

import android.widget.ProgressBar;

import com.marchuck.ProgressListener;
import com.marchuck.androidinterview.di.ActivityScope;
import com.marchuck.androidinterview.di.HasComponent;

import javax.inject.Inject;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */
@ActivityScope
public class ProgressListenerImpl implements ProgressListener {

    private HasComponent<ProgressBar> progressBarHasComponent;

    @Inject public ProgressListenerImpl(HasComponent<ProgressBar> progressBarHasComponent) {
        this.progressBarHasComponent = progressBarHasComponent;
    }

    @Override
    public void update(final long bytesRead, final long contentLength, final boolean done) {
        final ProgressBar bar = progressBarHasComponent.getComponent();
        if (bar != null) {
            bar.post(new Runnable() {
                @Override public void run() {
                    if (!done) {
                        bar.setProgress((int) (100 * bytesRead / contentLength));
                    } else {
                        bar.setProgress(100);
                    }
                }
            });
        }
    }
}
