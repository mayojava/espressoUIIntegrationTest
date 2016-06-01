package com.android.sample.espressouitestsample.signup;

import android.os.Handler;
import android.support.annotation.NonNull;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 */
public class SignUpPresenter implements SignUpContract.UserActionListener {
    private SignUpContract.View mSignUpActivityView;

    public SignUpPresenter(@NonNull SignUpContract.View view) {
        mSignUpActivityView = view;
    }
    @Override
    public void handleSignUpButtonClick() {
        //show progress bar
        mSignUpActivityView.showIndeterminateProgress(true);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSignUpActivityView.showIndeterminateProgress(false);
                mSignUpActivityView.showSuccessActivity();
            }
        }, 3000);
    }
}
