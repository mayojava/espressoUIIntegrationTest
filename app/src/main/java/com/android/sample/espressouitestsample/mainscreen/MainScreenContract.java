package com.android.sample.espressouitestsample.mainscreen;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 */
public interface MainScreenContract {
    interface View {
        void showLoginScreen();

        void showSignUpScreen();
    }

    interface UserActionListener {
        void signUp();

        void login();
    }
}
