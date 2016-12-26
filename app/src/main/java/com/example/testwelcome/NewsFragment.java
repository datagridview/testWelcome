package com.example.testwelcome;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.shizhefei.view.coolrefreshview.CoolRefreshView;
import com.shizhefei.view.coolrefreshview.SimpleOnPullListener;
import com.shizhefei.view.coolrefreshview.header.MaterialHeader;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CoolRefreshView coolRefreshView;
    private ImageView mCollectView;

    public NewsFragment() {}

    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_news, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        boolean isImmersive = false;
        final TitleBar titlebar = (TitleBar) getActivity().findViewById(R.id.title_bar);

        titlebar.setImmersive(isImmersive);

        titlebar.setBackgroundColor(Color.parseColor("#546379"));
        titlebar.setTitle("今日新闻");
        titlebar.setTitleColor(Color.WHITE);
        coolRefreshView = (CoolRefreshView) getView().findViewById(R.id.crv);
       //  coolRefreshView.setPullHeader(new MaterialHeader(getContext()));
        //添加刷新监听
        coolRefreshView.addOnPullListener(new SimpleOnPullListener() {
            @Override
            public void onRefreshing(CoolRefreshView refreshView) {

            }
        });
    }

}
