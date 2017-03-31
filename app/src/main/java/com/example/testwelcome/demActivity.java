package com.example.testwelcome;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class demActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);

        //有关titlebar类的定义使用
        boolean isImmersive = false;
        final TitleBar titlebar = (TitleBar) findViewById(R.id.title_bar);
        titlebar.setImmersive(isImmersive);
        titlebar.setBackgroundColor(Color.parseColor("#546379"));
        titlebar.setTitle("数学 比例线段\n三年级");
        titlebar.setTitleColor(Color.WHITE);
        titlebar.setLeftImageResource(R.drawable.arrow_left);
        titlebar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
