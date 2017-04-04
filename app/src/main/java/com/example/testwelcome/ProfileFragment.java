package com.example.testwelcome;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    //页面初始化
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    //页面活动初始化
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //titilebar初始化
        boolean isImmersive = false;
        final TitleBar titlebar = (TitleBar) getView().findViewById(R.id.title_bar);
        titlebar.setImmersive(isImmersive);
        titlebar.setBackgroundColor(Color.parseColor("#546379"));
        titlebar.setTitle("个人资料");
        titlebar.setTitleColor(Color.WHITE);

        LinearLayout noteLinearLayout=(LinearLayout) getView().findViewById(R.id.My_list_note);
        noteLinearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(),cameraActivity.class);
                startActivity(intent1);
            }
        }

        );
        LinearLayout profileLinearLayout=(LinearLayout) getView().findViewById(R.id.My_profile);
        profileLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), myProfileAvtivity.class);
                startActivity(intent1);
            }
        }

        );
        LinearLayout friendLinearLayout=(LinearLayout) getView().findViewById(R.id.My_friend);
        friendLinearLayout.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       Intent intent1 = new Intent(getActivity(), friendActivity.class);
                                                       startActivity(intent1);
                                                   }
                                               }

        );
    }

}
