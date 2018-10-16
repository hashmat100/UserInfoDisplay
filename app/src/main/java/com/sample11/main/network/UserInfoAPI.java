package com.sample11.main.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ashmath Khan on 15-10-2018.
 */

public interface UserInfoAPI {
    @GET("users/")
    Call<List<GetUserInfoVO>> getUserInfo();

    @GET("photos/")
    Call<List<GetAlbumInfoVO>> getAlbumInfo();
}
