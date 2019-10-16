package com.example.wanzixizuoye_one.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.wanzixizuoye_one.bean.MainBean;

import java.util.ArrayList;

public class MainVpAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<MainBean.DataBean.CategoryListBean> list;

    public MainVpAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<MainBean.DataBean.CategoryListBean> list) {
        super(fm);
        this.fragments = fragments;
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
