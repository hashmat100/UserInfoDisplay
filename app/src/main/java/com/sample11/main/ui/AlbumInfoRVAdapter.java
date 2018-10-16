package com.sample11.main.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample11.main.BR;
import com.sample11.main.R;
import com.sample11.main.network.GetAlbumInfoVO;

import java.util.List;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class AlbumInfoRVAdapter extends RecyclerView.Adapter<AlbumInfoRVAdapter.ViewHolder> {

    private List<GetAlbumInfoVO> mAlbumInfoList;
    private View.OnClickListener mOnClickListener;

    public AlbumInfoRVAdapter(List<GetAlbumInfoVO> albumInfoList, View.OnClickListener listener) {
        mAlbumInfoList = albumInfoList;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public AlbumInfoRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.fragment_screen2_item, viewGroup, false);

        return new AlbumInfoRVAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumInfoRVAdapter.ViewHolder viewHolder, int i) {

        GetAlbumInfoVO albumInfo = mAlbumInfoList.get(i);
        viewHolder.getViewDataBinding().setVariable(BR.albumInfo, albumInfo);
        viewHolder.getViewDataBinding().setVariable(BR.itemClickListener, mOnClickListener);
        viewHolder.getViewDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mAlbumInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding viewDataBinding;

        public ViewHolder(View view) {
            super(view);

            viewDataBinding = DataBindingUtil.bind(view);
            //view.setTag(viewDataBinding);
        }

        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }
    }
}
