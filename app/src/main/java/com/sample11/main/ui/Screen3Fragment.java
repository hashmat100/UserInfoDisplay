package com.sample11.main.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.sample11.main.R;
import com.sample11.main.base.BaseFragment;
import com.sample11.main.databinding.FragmentScreen3MainBinding;
import com.sample11.main.log.Log;
import com.sample11.main.network.GetAlbumInfoVO;

import static com.sample11.main.ui.Const.KEY_ALBUMINFO_JSON;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class Screen3Fragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        GetAlbumInfoVO vo = null;
        Bundle args = getArguments();
        if (args != null && args.getString(KEY_ALBUMINFO_JSON) != null) {
            Gson gson = new Gson();
            vo = gson.fromJson(args.getString(KEY_ALBUMINFO_JSON), GetAlbumInfoVO.class);
        } else {
            Log.error("null args");
        }

        //FragmentScreen3ItemBinding bindingVO = GetAlbumInfoVO.
        FragmentScreen3MainBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_screen3_main, container, false);

        View view = binding.getRoot();
        if (vo != null) {
            binding.setAlbumInfo(vo);
        }
        return view;
    }

    public static Screen3Fragment newInstance() {
        Screen3Fragment fragment = new Screen3Fragment();

        return fragment;
    }
}
