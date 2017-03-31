package com.example.testwelcome;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;


public class MainActivity extends Activity
{
    //定义全局变量
    int[] testColors = {0xFF1abc9c,0xFF5B4947,0xFF607D8B,0xFFF57C00,0xFFF57C00};
    Controller controller;
    List<Fragment> mFragments;
    ResourceFragment resourceFragment=new ResourceFragment();
    TimeFragment timeFragment=new TimeFragment();
    ProfileFragment profileFragment=new ProfileFragment();
    Fragment mContent=new Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        BottomTabTest();

    }

    //初始化碎片
    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(resourceFragment);
        mFragments.add(timeFragment);
        mFragments.add(profileFragment);
        mContent=resourceFragment;
    }

    //底边类
    private void BottomTabTest() {
        PagerBottomTabLayout pagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);

        //用TabItemBuilder构建一个导航按钮
        TabItemBuilder tabItemBuilder = new TabItemBuilder(this).create()
                .setDefaultIcon(android.R.drawable.ic_menu_compass)
                .setText("学习资源")
                .setDefaultColor(0xffffffff)
                .setSelectedColor(testColors[0])
                .setTag("A")
                .build();

        //构建导航栏,得到Controller进行后续控制
        controller = pagerBottomTabLayout.builder()
                .addTabItem(tabItemBuilder)
                .addTabItem(android.R.drawable.ic_menu_search, "学习之路",testColors[0])
                .addTabItem(android.R.drawable.ic_menu_help, "个人资料",testColors[0])
                .setDefaultColor(0xffffffff)
                //.setDefaultColor(0xa7aaa8)
                //.setMode(TabLayoutMode.HIDE_TEXT)
                //.setMode(TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                //.setMode(TabLayoutMode.HIDE_TEXT)
                .build();

        //controller.setMessageNumber("A",2);
        // controller.setDisplayOval(0,true);
        controller.setBackgroundColor(0xff546379);

        controller.addTabItemClickListener(listener);

    }


    //fragment呈现事件
    OnTabItemSelectListener listener = new OnTabItemSelectListener() {


        private FragmentManager fragmentManager = getFragmentManager();
        private FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        private void setDefaultFragment(Fragment fm) {
            fragmentTransaction.add(R.id.frameLayout, fm).commit();
            mContent = fm;
        }

        public void switchContent(Fragment to) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (mContent != to) {

                if (!to.isAdded()) { // 先判断是否被add过
                    transaction.hide(mContent).add(R.id.frameLayout, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
                } else {
                    transaction.hide(mContent).show(to).commit(); // 隐藏当前的fragment，显示下一个
                }

                mContent = to;
            }
            else transaction.replace(R.id.frameLayout,mContent).commit();
        }

        @Override
        public void onSelected(int index, Object tag) {
            //fragmentTransaction.add(R.id.frameLayout,mFragments.get(index)).commit();
            //setDefaultFragment(resourceFragment);
            switchContent(mFragments.get(index));
        }

        //重复点按事件
        @Override
        public void onRepeatClick(int index, Object tag) {
            Log.i("asd","onRepeatClick:"+index+"   TAG: "+tag.toString());
        }
    };


}




