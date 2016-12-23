package com.example.testwelcome;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.ParallaxPage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

public class MyWelcomeActivity extends WelcomeActivity {


    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.blue_background)
                .page(new BasicPage(R.drawable.ic_front_desk_white,
                        "欢迎",
                        "可以在这里搜索想要的任何学习资料。")
                        .background(R.color.orange_background)
                )

                .page(new BasicPage(R.drawable.ic_thumb_up_white,
                        "轻量",
                        "适合移动终端随时随地分享学习的愉悦。")
                        .background(R.color.red_background)
                )

                .page(new ParallaxPage(R.layout.parallax_example,
                        "简洁",
                        "流畅的用户体验。")
                        .lastParallaxFactor(2f)
                        .background(R.color.purple_background)
                )

                .page(new BasicPage(R.drawable.ic_edit_white,
                        "亲情奉献",
                        "XXX团队")
                        .background(R.color.blue_background)
                )

                .swipeToDismiss(true)
                .exitAnimation(android.R.anim.fade_out)
                .build();
    }

}
