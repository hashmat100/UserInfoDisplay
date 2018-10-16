package com.sample11.main.base;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class BaseFragment extends Fragment {
    public boolean isFragInvalid() {
        return getActivity() == null || getActivity().isDestroyed() ||
                getActivity().isFinishing() || !isAdded();
    }

    protected void addFragment(@IdRes int containerViewId,
                               @NonNull BaseFragment fragment) {
        if (!isFragInvalid()) {
            String name;
            if (fragment.getClass().getSuperclass() == null) {
                name = null;
            } else {
                name = fragment.getClass().getSuperclass().getSimpleName();
            }

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(containerViewId, fragment, name)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
