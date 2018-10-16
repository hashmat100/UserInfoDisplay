package com.sample11.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sample11.main.log.Log;
import com.sample11.main.network.BaseListener;
import com.sample11.main.network.GetAlbumInfoVO;
import com.sample11.main.network.UserInfoHttpClient;

import java.util.List;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class AlbumInfoViewModel extends AndroidViewModel {

    private MutableLiveData<List<GetAlbumInfoVO>> albumInfoList;

    public AlbumInfoViewModel(@NonNull Application application) {
        super(application);
    }

    //get user info list
    public LiveData<List<GetAlbumInfoVO>> getAlbumInfoList() {

        if (albumInfoList == null) {
            albumInfoList = new MutableLiveData<>();
            loadAlbumInfoList();
        }

        return albumInfoList;
    }

    // load userInfoList using retrofit from server
    private void loadAlbumInfoList() {
        UserInfoHttpClient.getInstance(getApplication()).getAlbumInfo(new BaseListener<List<GetAlbumInfoVO>>() {
            @Override
            public void onResponse(List<GetAlbumInfoVO> response) {
                if (response != null) {
                    albumInfoList.setValue(response);
                } else {
                    Log.error("response null");
                }
            }

            @Override
            public void onFailure(int error) {
                Log.error("Failed:" + error);
            }
        });
    }

    @BindingAdapter({"bind:loadUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(new RequestOptions().centerCrop())
                .into(view);
    }
}
