package com.sample11.main.base;

import android.support.v4.app.Fragment;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class BaseFragment extends Fragment {
    public boolean isFragInvalid() {
        return getActivity() == null || getActivity().isDestroyed() ||
                getActivity().isFinishing() || !isAdded();
    }
}
