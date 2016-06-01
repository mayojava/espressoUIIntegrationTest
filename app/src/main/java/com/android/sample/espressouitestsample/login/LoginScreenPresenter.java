package com.android.sample.espressouitestsample.login;

import android.os.Handler;
import android.support.annotation.NonNull;

/**
 * Created by mayowa.adegeye on 01/06/2016.
 */
public class LoginScreenPresenter implements LoginScreenContract.UserActionListener {
    private LoginScreenContract.View mLoginScreenView;

    public LoginScreenPresenter(@NonNull LoginScreenContract.View view) {
        mLoginScreenView = view;
    }
    @Override
    public void loginButtonClick() {
        mLoginScreenView.showProgressDialog(true);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginScreenView.showProgressDialog(false);
                mLoginScreenView.showLoginSuccessScreen();
            }
        }, 3000);
    }
}
