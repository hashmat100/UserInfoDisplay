package com.sample11.main.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample11.main.R;
import com.sample11.main.BR;
import com.sample11.main.log.Log;
import com.sample11.main.network.GetUserInfoVO;

import java.util.List;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class UserInfoRVAdapter extends RecyclerView.Adapter<UserInfoRVAdapter.ViewHolder> {

    private List<GetUserInfoVO> mUserInfoList;
    private View.OnClickListener onClickListener;

    public UserInfoRVAdapter(List<GetUserInfoVO> userInfoList) {
        mUserInfoList = userInfoList;

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.debug("Clicked:" + ((TextView)v.findViewById(R.id.idTV)).getText());
            }
        };
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.fragment_screen1_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        GetUserInfoVO userInfo = mUserInfoList.get(i);
        viewHolder.getViewDataBinding().setVariable(BR.userInfo, userInfo);
        viewHolder.getViewDataBinding().setVariable(BR.itemClickListener, onClickListener);
        viewHolder.getViewDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mUserInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding viewDataBinding;

        public ViewHolder(View view) {
            super(view);

            viewDataBinding = DataBindingUtil.bind(view);
            view.setTag(viewDataBinding);
        }

        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }
    }
}
