package com.sample11.main.network;

import android.content.Context;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Ashmath Khan on 15-10-2018.
 */

// Http client APIs to get user info
public class AlbumInfoHttpClient extends HttpClient<AlbumInfoAPI> {

    private static AlbumInfoHttpClient mHttpClient;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/photos/";

    private AlbumInfoHttpClient(Context appContext) {
        super(appContext);
    }

    public static AlbumInfoHttpClient getInstance(Context appContext) {

        if (mHttpClient == null) {
            synchronized (AlbumInfoHttpClient.class) {
                if (mHttpClient == null) {
                    mHttpClient = new AlbumInfoHttpClient(appContext);
                    return mHttpClient;
                }
            }
        }

        return mHttpClient;
    }

    public void getAlbumInfo(BaseListener<List<GetAlbumInfoVO>> baseListener) {
        BaseCallback callback = new BaseCallback(baseListener);
        Call<List<GetAlbumInfoVO>> call = getAPI().getAlbumInfo();
        call.enqueue(callback);
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }
}
