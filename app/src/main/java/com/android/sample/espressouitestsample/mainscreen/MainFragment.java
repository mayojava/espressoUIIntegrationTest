package com.android.sample.espressouitestsample.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.sample.espressouitestsample.BaseFragment;
import com.android.sample.espressouitestsample.R;
import com.android.sample.espressouitestsample.login.LoginActivity;
import com.android.sample.espressouitestsample.signup.SignUpActivity;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 */
public class MainFragment extends BaseFragment implements MainScreenContract.View{
    private MainScreenContract.UserActionListener mUserActionListener;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserActionListener = new MainScreenPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //set up sign up button
        Button signUpButton = (Button) view.findViewById(R.id.button_sign_up);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserActionListener.signUp();
            }
        });

        //set up login button
        Button loginButton = (Button)view.findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserActionListener.login();
            }
        });
    }

    @Override
    public void showLoginScreen() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showSignUpScreen() {
        Intent intent = new Intent(getActivity(), SignUpActivity.class);
        startActivity(intent);
    }
}
