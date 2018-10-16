package com.sample11.main.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample11.main.R;
import com.sample11.main.base.BaseFragment;
import com.sample11.main.log.Log;
import com.sample11.main.network.GetUserInfoVO;
import com.sample11.main.viewmodel.UserInfoViewModel;

import java.util.List;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class Screen1Fragment extends BaseFragment {

    RecyclerView mUserInfoRV;

    private final Observer<List<GetUserInfoVO>> mObserver = new Observer<List<GetUserInfoVO>>() {
        @Override
        public void onChanged(@Nullable List<GetUserInfoVO> userList) {
            Log.debug(userList.get(0).getPhone());

            UserInfoRVAdapter adapter = new UserInfoRVAdapter(userList);
            mUserInfoRV.setAdapter(adapter);
            mUserInfoRV.setHasFixedSize(true);
            adapter.notifyDataSetChanged();
        }
    };

    public static Screen1Fragment newInstance() {
        Screen1Fragment fragment = new Screen1Fragment();

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        UserInfoViewModel model = ViewModelProviders.of(this).get(UserInfoViewModel.class);

        //remove and add to solve an issue with fragments
        // details: https://medium.com/@BladeCoder/architecture-components-pitfalls-part-1-9300dd969808
        model.getUserInfoList().removeObserver(mObserver);
        model.getUserInfoList().observe(this, mObserver);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_screen1_main, container, false);

        mUserInfoRV = view.findViewById(R.id.userInfoRV);
        mUserInfoRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
