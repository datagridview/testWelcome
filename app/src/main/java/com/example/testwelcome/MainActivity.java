package com.example.testwelcome;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

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
    private AccountHeader headerResult;
    private Drawer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        BottomTabTest();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getString(R.string.drawer_item_collapsing_toolbar_drawer));

//        headerResult = new AccountHeaderBuilder()
//                .withActivity(this)
//                .withCompactStyle(false)
//                .withHeaderBackground(R.drawable.header)
//                .withSavedInstance(savedInstanceState)
//                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .withFullscreen(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_gamepad),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_eye),
                        new SectionDrawerItem().withName(R.string.drawer_item_section_header),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question).withEnabled(false),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_github),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_bullhorn)
                )
                .withSavedInstance(savedInstanceState)
                .build();

        fillFab();
        loadBackdrop();
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

//        private void setDefaultFragment(Fragment fm) {
//            fragmentTransaction.add(R.id.frameLayout, fm).commit();
//            mContent = fm;
//        }

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
    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        //Glide.with(this).load("https://unsplash.it/600/300/?random").centerCrop().into(imageView);
    }

    private void fillFab() {
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floating_action_button);
        //fab.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_favorite).actionBar().color(Color.WHITE));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        //outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }


}




