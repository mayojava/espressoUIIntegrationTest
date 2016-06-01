package com.android.sample.espressouitestsample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.sample.espressouitestsample.BaseFragment;
import com.android.sample.espressouitestsample.R;
import com.android.sample.espressouitestsample.SuccessActivity;

/**
 * Created by mayowa.adegeye on 01/06/2016.
 */
public class LoginFragment extends BaseFragment implements LoginScreenContract.View {
    private LoginScreenContract.UserActionListener mUserActionListener;
    private ProgressBar mProgressBar;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserActionListener = new LoginScreenPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = (Button)view.findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserActionListener.loginButtonClick();
            }
        });

        mProgressBar = (ProgressBar)view.findViewById(R.id.progress_bar_login);
    }

    @Override
    public void showProgressDialog(boolean visible) {
        mProgressBar.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showLoginSuccessScreen() {
        Intent intent = new Intent(getActivity(), SuccessActivity.class);
        intent.putExtra(SuccessActivity.STATUS_MESSAGE, getString(R.string.text_login_successful));
        startActivity(intent);
    }
}
