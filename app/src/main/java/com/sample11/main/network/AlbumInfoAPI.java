package com.sample11.main.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ashmath Khan on 15-10-2018.
 */

public interface AlbumInfoAPI {
    @GET(".")
    Call<List<GetAlbumInfoVO>> getAlbumInfo();
}
