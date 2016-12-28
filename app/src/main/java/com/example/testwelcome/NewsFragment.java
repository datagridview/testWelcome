package com.example.testwelcome;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.ericliu.asyncexpandablelist.CollectionView;
import com.ericliu.asyncexpandablelist.CollectionViewCallbacks;
import com.shizhefei.view.coolrefreshview.CoolRefreshView;
import com.shizhefei.view.coolrefreshview.SimpleOnPullListener;
import com.shizhefei.view.coolrefreshview.header.MaterialHeader;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment implements CollectionViewCallbacks<String, News> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CoolRefreshView coolRefreshView;
    private CollectionView<String, News> mCollectionView;
    private CollectionView.Inventory<String, News> inventory;

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
        titlebar.setLeftImageResource(R.drawable.head1);
        coolRefreshView = (CoolRefreshView) getView().findViewById(R.id.crv);
       //  coolRefreshView.setPullHeader(new MaterialHeader(getContext()));
        //添加刷新监听
        coolRefreshView.addOnPullListener(new SimpleOnPullListener() {
            @Override
            public void onRefreshing(CoolRefreshView refreshView) {

            }
        });


        mCollectionView = (CollectionView) getActivity().findViewById(R.id.collectionView);
        mCollectionView.setCollectionCallbacks(this);

        inventory = CollectionView.Inventory.newInstance();

        // groupOrdinal dictates the sequence of groups to be displayed in the list,
        // the groups will be displayed in an ascending order on groupOrdinal
        int groupOrdinal = 0;
        CollectionView.InventoryGroup<String, News> group1 = inventory.newGroup(groupOrdinal);
        News news;

        group1.setHeaderItem(getString(R.string.news_header_top_stories));
        news = new News();
        news.setNewsTitle(getString(R.string.news_title1));
        news.setNewsBody(getString(R.string.news_body1));
        group1.addItem(news);

        news = new News();
        news.setNewsTitle(getString(R.string.news_title2));
        news.setNewsBody(getString(R.string.news_body2));
        group1.addItem(news);

        news = new News();
        news.setNewsTitle(getString(R.string.news_title_3));
        news.setNewsBody(getString(R.string.news_body3));
        group1.addItem(news);

        CollectionView.InventoryGroup<String, News> group2 = inventory.newGroup(2);
        group2.setHeaderItem(getString(R.string.news_header_world));

        news = new News();
        news.setNewsTitle(getString(R.string.news_title4));
        news.setNewsBody(getString(R.string.news_body4));
        group2.addItem(news);

//        news = new News();
//        news.setNewsTitle(getString(R.string.news_title5));
//        news.setNewsBody(getString(R.string.news_body5));
//        group2.addItem(news);



        CollectionView.InventoryGroup<String, News> group3 = inventory.newGroup(3); // 2 is smaller than 10, displayed second
        group3.setHeaderItem(getString(R.string.news_header_australia));

        news = new News();
        news.setNewsTitle(getString(R.string.news_title6));
        news.setNewsBody(getString(R.string.news_body6));
        group3.addItem(news);

        news = new News();
        news.setNewsTitle(getString(R.string.news_title7));
        news.setNewsBody(getString(R.string.news_body7));
        group3.addItem(news);

//
//        news = new News();
//        news.setNewsTitle(getString(R.string.news_title8));
//        news.setNewsBody(getString(R.string.news_body8));
//        group3.addItem(news);


        mCollectionView.updateInventory(inventory);
}


    @Override
    public RecyclerView.ViewHolder newCollectionHeaderView(Context context, int groupOrdinal, ViewGroup parent) {
        // Create a new view.
        View v = LayoutInflater.from(context)
                .inflate(R.layout.header_row_item, parent, false);

        return new TitleHolder(v);
    }

    @Override
    public RecyclerView.ViewHolder newCollectionItemView(Context context, int groupOrdinal, ViewGroup parent) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.text_row_item, parent, false);

        return new NewsItemHolder(v);
    }

    @Override
    public void bindCollectionHeaderView(Context context, RecyclerView.ViewHolder holder, int groupOrdinal, String headerItem) {
        ((TitleHolder) holder).getTextView().setText((String) headerItem);
    }

    @Override
    public void bindCollectionItemView(Context context, RecyclerView.ViewHolder holder, int groupOrdinal, News item) {
        NewsItemHolder newsItemHolder = (NewsItemHolder) holder;
        newsItemHolder.getTextViewTitle().setText(item.getNewsTitle());
        newsItemHolder.getTextViewDescrption().setText(item.getNewsBody());
    }

    public static class TitleHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public TitleHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public static class NewsItemHolder extends RecyclerView.ViewHolder {


        private final TextView tvTitle;
        private final TextView tvDescription;

        public NewsItemHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            tvTitle = (TextView) v.findViewById(R.id.title);
            tvDescription = (TextView) v.findViewById(R.id.description);
        }

        public TextView getTextViewTitle() {
            return tvTitle;
        }

        public TextView getTextViewDescrption() {
            return tvDescription;
        }
    }
}



