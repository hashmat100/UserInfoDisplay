package com.sample11.main.base;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class BaseActivity extends AppCompatActivity {

    protected void replaceFragment(@IdRes int containerViewId,
                                   @NonNull BaseFragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commitAllowingStateLoss();
    }

    protected void addFragment(@IdRes int containerViewId,
                               @NonNull BaseFragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commitAllowingStateLoss();
    }

    protected BaseFragment getFragmentByTag(String name) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(name);

        if (fragment instanceof BaseFragment) {
            return (BaseFragment) fragment;
        } else {
            return null;
        }
    }

}
