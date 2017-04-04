package com.example.testwelcome;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import pl.coreorb.selectiondialogs.views.SelectedItemView;


public class MyProfileFragment extends Fragment {



    private SelectedItemView textSIV1;
    private SelectedItemView textSIV2;
    private SelectedItemView textSIV3;
    private SelectedItemView textSIV4;
    private SelectedItemView textSIV5;
    private SelectedItemView textSIV6;
    public MyProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_profile, container, false);


        textSIV1 = (SelectedItemView) rootView.findViewById(R.id.text_siv1);
        textSIV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextInputDialog(textSIV1);
            }
        });
        textSIV2 = (SelectedItemView) rootView.findViewById(R.id.text_siv2);
        textSIV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextInputDialog(textSIV2);
            }
        });
        textSIV3 = (SelectedItemView) rootView.findViewById(R.id.text_siv3);
        textSIV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextInputDialog(textSIV3);
            }
        });
        textSIV4 = (SelectedItemView) rootView.findViewById(R.id.text_siv4);
        textSIV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextInputDialog(textSIV4);
            }
        });
        textSIV5 = (SelectedItemView) rootView.findViewById(R.id.text_siv5);
        textSIV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextInputDialog(textSIV5);
            }
        });
        textSIV6 = (SelectedItemView) rootView.findViewById(R.id.text_siv6);
        textSIV6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextInputDialog(textSIV6);
            }
        });

        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Button btnEnter=(Button) getActivity().findViewById(R.id.btnEnter);
//
//        //按钮事件
//        btnEnter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getActivity(),CollapsingToolbarActivity.class);
//                startActivity(intent);
//            }
//        });
    }


    private void showTextInputDialog(final SelectedItemView textSIV) {
        final EditText textET = new EditText(getContext());

        new AlertDialog.Builder(getContext())
                .setTitle(R.string.text_input_dialog_title)
                .setView(textET)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        textSIV.setSelectedName(textET.getText().toString());
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .show();
    }

}
