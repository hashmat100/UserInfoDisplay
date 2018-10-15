package com.sample11.main.network;

/**
 * Created by Ashmath Khan on 25-02-2018.
 */

// base listener interface for retrofit
// the methods here are made abstract now unless there is some action to be put for extensibility
// like sending only T in response
public interface BaseListener<T> {

    void onResponse(T response);

    void onFailure(int error);
}
