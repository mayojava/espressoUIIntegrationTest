package com.android.sample.espressouitestsample.mainscreen;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.android.sample.espressouitestsample.BaseActivity;
import com.android.sample.espressouitestsample.R;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 */
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar(toolbar);

        //start fragment
        startFragment(MainFragment.newInstance());
    }
}
