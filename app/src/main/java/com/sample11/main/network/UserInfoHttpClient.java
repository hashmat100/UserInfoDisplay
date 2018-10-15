package com.sample11.main.network;

import android.content.Context;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Ashmath Khan on 15-10-2018.
 */

// Http client APIs to get user info
public class UserInfoHttpClient extends HttpClient<UserInfoAPI> {

    private static UserInfoHttpClient mHttpClient;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users/";

    private UserInfoHttpClient(Context appContext) {
        super(appContext);
    }

    public static UserInfoHttpClient getInstance(Context appContext) {

        if (mHttpClient == null) {
            synchronized (UserInfoHttpClient.class) {
                if (mHttpClient == null) {
                    mHttpClient = new UserInfoHttpClient(appContext);
                    return mHttpClient;
                }
            }
        }

        return mHttpClient;
    }

    public void getUserInfo(BaseListener<List<GetUserInfoVO>> baseListener) {
        BaseCallback callback = new BaseCallback(baseListener);
        Call<List<GetUserInfoVO>> call = getAPI().getUserInfo();
        call.enqueue(callback);
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }
}
