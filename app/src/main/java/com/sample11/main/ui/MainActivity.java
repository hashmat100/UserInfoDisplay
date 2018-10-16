package com.sample11.main.ui;

import android.os.Bundle;

import com.sample11.main.R;
import com.sample11.main.base.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load Screen1 initially
        // Find the retained fragment on activity restarts
        Screen1Fragment fragment = (Screen1Fragment) getFragmentByTag(Screen1Fragment.class.getName());

        if (fragment == null) {
            replaceFragment(R.id.mainContainer, Screen1Fragment.newInstance());
        }

    }

    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();

        if (fragments > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
