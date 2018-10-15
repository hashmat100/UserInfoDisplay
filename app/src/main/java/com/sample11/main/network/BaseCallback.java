package com.sample11.main.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ashmath Khan on 27-02-2018.
 */

public class BaseCallback<T> implements Callback<T> {

    public static final int SERVER_ERROR = 1;
    public static final int NETWORK_ERROR = 2;

    BaseListener<T> baseListener;

    public BaseCallback(BaseListener<T> baseListener) {
        this.baseListener = baseListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response == null || response.body() == null ||
                !response.isSuccessful()) {
            baseListener.onFailure(SERVER_ERROR);
        } else {
            baseListener.onResponse(response.body());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        baseListener.onFailure(NETWORK_ERROR);
    }
}
