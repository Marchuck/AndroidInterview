package com.marchuck.androidinterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.marchuck.NetworkResponse;
import com.marchuck.androidinterview.di.HasComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements HasComponent<ProgressBar>, MainView {

    public static final String TAG = MainActivity.class.getSimpleName();

    @OnClick(R.id.activity_main_button_fetch) void buttonFetchClicked() {
        presenter.requestData();
    }

    @BindView(R.id.activity_main_progressbar) ProgressBar progressbar;
    @BindView(R.id.activity_main_textview_) TextView textview;

    @Inject MainPresenter presenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getApp(this).createActivityComponent(this).inject(this);
    }

    @Override public ProgressBar getComponent() {
        return progressbar;
    }

    @Override public void onResponse(NetworkResponse response) {
        Log.i(TAG, "onResponse: ");
        textview.setText(Html.fromHtml(response.getResponse()));
    }

    @Override public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
