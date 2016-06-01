package com.android.sample.espressouitestsample.signup;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 */
public interface SignUpContract {
    interface View {
        void showIndeterminateProgress(boolean visible);

        void showSuccessActivity();
    }

    interface UserActionListener {
        void handleSignUpButtonClick();
    }
}
