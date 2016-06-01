package com.android.sample.espressouitestsample.signup;

import android.app.ProgressDialog;
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
 * Created by mayowa.adegeye on 31/05/2016.
 */
public class SignUpFragment extends BaseFragment implements SignUpContract.View {
    private SignUpContract.UserActionListener mSignUpActivityUserActionListener;

    private ProgressBar mProgressDialog;

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSignUpActivityUserActionListener = new SignUpPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button signUpButton = (Button)view.findViewById(R.id.button_sign_up);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSignUpActivityUserActionListener.handleSignUpButtonClick();
            }
        });

        mProgressDialog = (ProgressBar) view.findViewById(R.id.progress_bar_indeterminate);
    }


    @Override
    public void showIndeterminateProgress(boolean visible) {
        mProgressDialog.setVisibility(visible ? View.VISIBLE : View.GONE);
    }


    @Override
    public void showSuccessActivity() {
        Intent intent = new Intent(getActivity(), SuccessActivity.class);
        intent.putExtra(SuccessActivity.STATUS_MESSAGE, getString(R.string.text_sign_up_successful));
        startActivity(intent);
    }
}
