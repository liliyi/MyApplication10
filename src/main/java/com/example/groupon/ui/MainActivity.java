package com.example.groupon.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.groupon.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {
    //Handler handler;
    ListView listView;
    List<String> datas;
    ArrayAdapter<String> adapter;

    ViewPager viewPager;

    //头部
    @BindView(R.id.head_menu)
    ImageView headMenu;
    @BindView(R.id.head_city)
    TextView headCity;
    @BindView(R.id.head_linear)
    LinearLayout headLinear;

    @BindView(R.id.main_menu)
    View menuLayout;


    //中
    @BindView(R.id.ptrlv_main)
    PullToRefreshListView ptrlvMain;

    //尾

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListView();

    }

    @OnClick(R.id.head_linear)
    public void JumpToCity(View view) {


    }

    @OnClick(R.id.head_menu)
    public void toggleMenu(View view) {
        if(menuLayout.getVisibility()==View.VISIBLE){
            menuLayout.setVisibility(View.INVISIBLE);
        }else{
            menuLayout.setVisibility(View.VISIBLE);
        }

    }

    private void initListView() {

        listView = ptrlvMain.getRefreshableView();
        datas = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        View iconsView = layoutInflater.inflate(R.layout.header_list_icons, listView, false);
        View squareView = layoutInflater.inflate(R.layout.header_list_square, listView, false);
        View boby = layoutInflater.inflate(R.layout.include_boby, listView, false);


        listView.addHeaderView(iconsView);
        listView.addHeaderView(squareView);
        listView.addHeaderView(boby);

        listView.setAdapter(adapter);
        initListHeaderIcons(iconsView);

        //添加下拉松手后的刷新
        ptrlvMain.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // datas.add(0,"新增内容");
                        adapter.notifyDataSetChanged();
                        ptrlvMain.onRefreshComplete();
                    }
                }, 1500);

            }
        });


    }

    private void initListHeaderIcons(View listHeaderIcons) {
        final ViewPager viewPager = (ViewPager) listHeaderIcons.findViewById(R.id.viewpages);

        PagerAdapter adapter = new PagerAdapter() {
            int[] resIDs = new int[]{
                    R.layout.viewpage1,
                    R.layout.viewpage2,
                    R.layout.viewpage3};
            @Override
            public int getCount() {
                return 30000;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                int layoutId = resIDs[position%3];
                View view = LayoutInflater.from(MainActivity.this).inflate(layoutId,viewPager,false);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view ==object;
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(15000);

    }


    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {

        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");
        datas.add("ddd");
        datas.add("eee");
        datas.add("fff");
        datas.add("ggg");
        datas.add("hhh");
        datas.add("jjj");
        adapter.notifyDataSetChanged();

    }
}

