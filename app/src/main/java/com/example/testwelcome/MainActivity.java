package com.example.testwelcome;
        import android.app.Activity;
        import android.app.Fragment;
        import android.app.FragmentManager;
        import android.app.FragmentTransaction;
        import android.os.Bundle;

        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;


        import com.mxn.soul.flowingdrawer_core.FlowingView;
        import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

        import java.util.ArrayList;
        import java.util.List;

        import me.majiajie.pagerbottomtabstrip.Controller;
        import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
        import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
        import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
        import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;


public class MainActivity extends Activity
{
    //    int[] testColors = {0xFF7BA3A8,0xFFF4F3DE,0xFFBEAD92,0xFFF35A4A,0xFF5B4947};
    //    int[] testColors = {0xFF00796B,0xFF8D6E63,0xFF2196F3,0xFF607D8B,0xFFF57C00};
    int[] testColors = {0xFF1abc9c,0xFF5B4947,0xFF607D8B,0xFFF57C00,0xFFF57C00};

    Controller controller;

    List<Fragment> mFragments;
    NewsFragment newsFragment=new NewsFragment();
    ResourceFragment resourceFragment=new ResourceFragment();
    TimeFragment timeFragment=new TimeFragment();
    ProfileFragment profileFragment=new ProfileFragment();

    private TitleBar titlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        BottomTabTest();
    }

    private void initFragment()
    {
        mFragments = new ArrayList<>();
        mFragments.add(newsFragment);
        mFragments.add(resourceFragment);
        mFragments.add(timeFragment);
        mFragments.add(profileFragment);


//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        // transaction.setCustomAnimations(R.anim.push_up_in,R.anim.push_up_out);
//        transaction.add(R.id.frameLayout,mFragments.get(0));
//        transaction.commit();
    }

    private void BottomTabTest()
    {
        PagerBottomTabLayout pagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);





        //用TabItemBuilder构建一个导航按钮
        TabItemBuilder tabItemBuilder = new TabItemBuilder(this).create()
                .setDefaultIcon(android.R.drawable.ic_menu_send)
                .setText("今日新闻")
                .setDefaultColor(0xffffffff)
                .setSelectedColor(testColors[0])
                .setTag("A")
                .build();

        //构建导航栏,得到Controller进行后续控制
        controller = pagerBottomTabLayout.builder()
                .addTabItem(tabItemBuilder)
                .addTabItem(android.R.drawable.ic_menu_compass, "学习资源",testColors[0])
                .addTabItem(android.R.drawable.ic_menu_search, "学习之路",testColors[0])
                .addTabItem(android.R.drawable.ic_menu_help, "个人资料",testColors[0])
                .setDefaultColor(0xffffffff)
                //.setDefaultColor(0xa7aaa8)
//                .setMode(TabLayoutMode.HIDE_TEXT)
                //.setMode(TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                //.setMode(TabLayoutMode.HIDE_TEXT)
                .build();

 //       controller.setMessageNumber("A",2);
      // controller.setDisplayOval(0,true);
        controller.setBackgroundColor(0xff546379);

        controller.addTabItemClickListener(listener);
    }



    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag)
        {
//            Log.i("asd","onSelected:"+index+"   TAG: "+tag.toString());
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //transaction.setCustomAnimations(R.anim.push_up_in,R.anim.push_up_out);
            fragmentTransaction.replace(R.id.frameLayout,mFragments.get(index));
            fragmentTransaction.commit();
    }

        @Override
        public void onRepeatClick(int index, Object tag) {
            Log.i("asd","onRepeatClick:"+index+"   TAG: "+tag.toString());
        }
    };

}




