package com.android.sample.espressouitestsample.mainscreen;

import android.support.annotation.NonNull;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 *
 * Specifies contract between view and presenter
 */


public class MainScreenPresenter implements MainScreenContract.UserActionListener{

    private MainScreenContract.View mMainScreenView;

    public MainScreenPresenter(@NonNull MainScreenContract.View view) {
        mMainScreenView = view;
    }

    @Override
    public void signUp() {
        mMainScreenView.showSignUpScreen();
    }

    @Override
    public void login() {
        mMainScreenView.showLoginScreen();
    }
}
