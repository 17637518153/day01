package com.example.wanzixizuoye_one;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.wanzixizuoye_one.adapter.MainVpAdapter;
import com.example.wanzixizuoye_one.bean.MainBean;
import com.example.wanzixizuoye_one.fragment.MainFragment;
import com.example.wanzixizuoye_one.presenter.IPresenterlist;
import com.example.wanzixizuoye_one.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.tab_vertical)
    VerticalTabLayout tabVertical;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> fragments;
    private MainVpAdapter adapter;
    private ArrayList<MainBean.DataBean.CategoryListBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        IPresenterlist iPresenterlist = new IPresenterlist(this);
        iPresenterlist.getTabData();
    }

    private void initView() {
        fragments = new ArrayList<>();
        list = new ArrayList<>();


        adapter = new MainVpAdapter(getSupportFragmentManager(), fragments, list);
        vp.setAdapter(adapter);

        tabVertical.setupWithViewPager(vp);

    }

    @Override
    public void OnSuccess(MainBean mainBean) {
        final List<MainBean.DataBean.CategoryListBean> categoryList = mainBean.getData().getCategoryList();

        for (int i = 0; i < categoryList.size(); i++) {
            list.addAll(categoryList);

            MainFragment mainFragment = new MainFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id",list.get(i).getId()+"");
            mainFragment.setArguments(bundle);

            fragments.add(mainFragment);
        }
        adapter.notifyDataSetChanged();


    }

    @Override
    public void OnFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
