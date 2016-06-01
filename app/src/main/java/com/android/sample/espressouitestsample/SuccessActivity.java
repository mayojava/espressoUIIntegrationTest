package com.android.sample.espressouitestsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 */
public class SuccessActivity extends BaseActivity {
    public static final String STATUS_MESSAGE = "message";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        String message = getIntent().getStringExtra(STATUS_MESSAGE);
        TextView textView = (TextView)findViewById(R.id.text_view_status_message);
        textView.setText(message);
    }
}
