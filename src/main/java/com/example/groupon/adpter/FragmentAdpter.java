package com.example.groupon.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.groupon.fragment.FourthFragment;
import com.example.groupon.fragment.FristFragment;
import com.example.groupon.fragment.SecondFragment;
import com.example.groupon.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarena on 2017/6/15.
 */

public class FragmentAdpter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public FragmentAdpter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<Fragment>();

        mFragments.add(new FristFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mFragments.add(new FourthFragment());

    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub   索 引
        return mFragments.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub   个数
        return mFragments.size();
    }

}
