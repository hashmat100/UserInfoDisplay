package com.sample11.main.network;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class GetAlbumInfoVO extends BaseObservable {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Bindable
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Bindable
    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public void setUrl(String url) {
        this.url = url;
    }

    @Bindable
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

}
