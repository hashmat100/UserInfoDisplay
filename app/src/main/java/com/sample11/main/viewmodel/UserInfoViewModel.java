package com.sample11.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.sample11.main.log.Log;
import com.sample11.main.network.BaseListener;
import com.sample11.main.network.GetUserInfoVO;
import com.sample11.main.network.UserInfoHttpClient;

import java.util.List;

/**
 * Created by Ashmath Khan on 16-10-2018.
 * ViewModel for the user info list data from server
 */
public class UserInfoViewModel extends AndroidViewModel {

    private MutableLiveData<List<GetUserInfoVO>> userInfoList;

    public UserInfoViewModel(@NonNull Application application) {
        super(application);
    }

    //get user info list
    public LiveData<List<GetUserInfoVO>> getUserInfoList() {

        if (userInfoList == null) {
            userInfoList = new MutableLiveData<List<GetUserInfoVO>>();
            loadUserInfoList();
        }

        return userInfoList;
    }

    // load userInfoList using retrofit from server
    private void loadUserInfoList() {
        UserInfoHttpClient.getInstance(getApplication()).getUserInfo(new BaseListener<List<GetUserInfoVO>>() {
            @Override
            public void onResponse(List<GetUserInfoVO> response) {
                userInfoList.setValue(response);
            }

            @Override
            public void onFailure(int error) {
                Log.error("Failed:" + error);
            }
        });
    }

}
