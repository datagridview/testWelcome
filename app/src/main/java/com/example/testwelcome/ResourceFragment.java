package com.example.testwelcome;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.shizhefei.view.coolrefreshview.CoolRefreshView;
import com.shizhefei.view.coolrefreshview.SimpleOnPullListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResourceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResourceFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentManager manager;
    private FragmentTransaction ft;

    public ResourceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResourceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResourceFragment newInstance(String param1, String param2) {
        ResourceFragment fragment = new ResourceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = getFragmentManager();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resource, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        boolean isImmersive = false;
        final TitleBar titlebar = (TitleBar) getActivity().findViewById(R.id.title_bar);
        titlebar.setImmersive(isImmersive);
        titlebar.setBackgroundColor(Color.parseColor("#546379"));
        titlebar.setTitle("学习资源");
        titlebar.setTitleColor(Color.WHITE);
        titlebar.setLeftImageResource(R.drawable.head1);
        Button btnMath=(Button) getActivity().findViewById(R.id.btnMath);
        btnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(),demActivity.class);
                startActivity(intent1);
            }
        });

    }
}
