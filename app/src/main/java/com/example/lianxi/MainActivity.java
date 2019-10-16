package com.example.lianxi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.lianxi.adapter.mainAdapter;
import com.example.lianxi.bean.MainBean;
import com.example.lianxi.presenter.IPresenterlist;
import com.example.lianxi.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tablist)
    TabLayout tablist;
    private List<MainBean.DataBean.BrandListBean> list;
    private mainAdapter addapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    //初始化
    private void initData() {
        IPresenterlist iPresenterlist = new IPresenterlist(this);
        iPresenterlist.getMainData();
    }

    private void initView() {
        //设置布局管理器
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        //创建集合
        list = new ArrayList<>();
        //创建适配器
        addapter = new mainAdapter(this, list);
        rv.setAdapter(addapter);
    }

    @Override
    public void OnSuccess(MainBean mainBean) {
        List<MainBean.DataBean.BrandListBean> brandList = mainBean.getData().getBrandList();
        List<MainBean.DataBean.ChannelBean> channel = mainBean.getData().getChannel();
        list.addAll(brandList);

        for (int i = 0; i < channel.size(); i++) {
            tablist.addTab(tablist.newTab().setText(channel.get(i).getName()));
        }
        addapter.notifyDataSetChanged();

    }

    @Override
    public void OnFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
