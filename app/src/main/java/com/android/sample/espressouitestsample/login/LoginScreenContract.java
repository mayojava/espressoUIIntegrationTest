package com.android.sample.espressouitestsample.login;

/**
 * Created by mayowa.adegeye on 01/06/2016.
 */
public interface LoginScreenContract {

    interface View {
        void showProgressDialog(boolean visible);

        void showLoginSuccessScreen();
    }

    interface UserActionListener {
        void loginButtonClick();
    }
}
