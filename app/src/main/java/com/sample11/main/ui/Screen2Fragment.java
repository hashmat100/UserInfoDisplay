package com.sample11.main.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sample11.main.R;
import com.sample11.main.base.BaseFragment;
import com.sample11.main.log.Log;
import com.sample11.main.network.GetAlbumInfoVO;
import com.sample11.main.viewmodel.AlbumInfoViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.sample11.main.ui.Const.KEY_ALBUMINFO_JSON;
import static com.sample11.main.ui.Const.KEY_ID;

/**
 * Created by Ashmath Khan on 16-10-2018.
 */
public class Screen2Fragment extends BaseFragment {

    private int userId;
    private RecyclerView mAlbumInfoRV;

    private final Observer<List<GetAlbumInfoVO>> mObserver = new Observer<List<GetAlbumInfoVO>>() {
        @Override
        public void onChanged(@Nullable List<GetAlbumInfoVO> albumInfoList) {
            //Log.debug(.get(0).getPhone());

            final List<GetAlbumInfoVO> matchingList = new ArrayList<>();
            for (GetAlbumInfoVO album : albumInfoList) {
                if (album.getAlbumId() == userId) {
                    matchingList.add(album);
                }
            }

            //populate recycler view on data reception
            AlbumInfoRVAdapter adapter = new AlbumInfoRVAdapter(matchingList, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getParent() instanceof ViewGroup &&
                            ((ViewGroup) v.getParent()).getTag() instanceof GetAlbumInfoVO) {

                        GetAlbumInfoVO vo = (GetAlbumInfoVO) ((ViewGroup) v.getParent()).getTag();

                        Bundle args = new Bundle();
                        Gson gson = new Gson();
                        String json = gson.toJson(vo);
                        args.putString(KEY_ALBUMINFO_JSON, json);

                        Screen3Fragment frag = Screen3Fragment.newInstance();
                        frag.setArguments(args);
                        addFragment(R.id.mainContainer, frag);
                    } else {
                        Log.error("type error");
                    }
                }
            });
            mAlbumInfoRV.setAdapter(adapter);
            mAlbumInfoRV.setHasFixedSize(true);
            adapter.notifyDataSetChanged();
        }
    };

    public static Screen2Fragment newInstance() {
        Screen2Fragment fragment = new Screen2Fragment();

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AlbumInfoViewModel model = ViewModelProviders.of(this).get(AlbumInfoViewModel.class);

        //remove and add to solve an issue with fragments
        // details: https://medium.com/@BladeCoder/architecture-components-pitfalls-part-1-9300dd969808
        model.getAlbumInfoList().removeObserver(mObserver);
        model.getAlbumInfoList().observe(this, mObserver);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_screen2_main, container, false);

        mAlbumInfoRV = view.findViewById(R.id.albumInfoRV);
        mAlbumInfoRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        Bundle args = getArguments();
        if (args != null) {
            userId = args.getInt(KEY_ID);
        } else {
            Log.error("args null");
        }

        String header = getResources().getString(R.string.albumHeader, String.valueOf(userId));
        ((TextView) view.findViewById(R.id.albumHeaderTV)).setText(header);

        return view;
    }

}
