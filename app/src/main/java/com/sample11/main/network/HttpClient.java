package com.sample11.main.network;

import android.content.Context;

import com.sample11.main.log.Log;

import java.io.File;
import java.lang.reflect.ParameterizedType;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ashmath Khan on 25-02-2018.
 */

// Http client using retrofit
public abstract class HttpClient<T> {

    private static final int CACHE_SIZE = 1 * 1024 * 1024; // 1 MB
    private static final String CACHE_SUB_PATH = "okhttpfacts";

    private Retrofit mRetrofit;
    private T mAPI;
    private Context mContext;


    protected HttpClient(Context appContext) {

        mContext = appContext;
        File cacheDir = new File(mContext.getCacheDir(), CACHE_SUB_PATH);
        Cache cache = new Cache(cacheDir, CACHE_SIZE);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create api
        try {
            Class<T> type = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
            mAPI = mRetrofit.create(type);
        } catch (Exception error) {
            Log.error(error.getMessage());
        }
    }

    protected T getAPI() {
        return mAPI;
    }

    protected abstract String getBaseUrl();

}
