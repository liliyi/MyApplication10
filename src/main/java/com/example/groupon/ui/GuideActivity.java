package com.example.groupon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.example.groupon.R;
import com.example.groupon.adpter.FragmentAdpter;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends FragmentActivity {
    ViewPager viewpager;
    FragmentAdpter adpter;
    TextView jump;

    @BindView(R.id.indicator)
    CirclePageIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initViewPager();
    }

    private void initViewPager() {
        jump = (TextView) findViewById(R.id.jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });

        viewpager = (ViewPager) findViewById(R.id.viewpage);
        adpter = new FragmentAdpter(getSupportFragmentManager());
        viewpager.setAdapter(adpter);

        indicator.setViewPager(viewpager);

        //另一种获取
        float px= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics());

        //屏幕密度
        final float density = getResources().getDisplayMetrics().density;
        indicator.setBackgroundColor(0xFFffffff);
        indicator.setRadius(4 * density);
        indicator.setPageColor(0xFFffffff);
        indicator.setFillColor(0xFFFF6633);
        indicator.setStrokeColor(0xFF635C5E);
        indicator.setStrokeWidth(1 * density);


        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position ==3){
                    indicator.setVisibility(View.GONE);
                }else {
                    indicator.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
}
