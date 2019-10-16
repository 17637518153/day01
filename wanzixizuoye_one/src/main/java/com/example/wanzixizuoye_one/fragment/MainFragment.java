package com.example.wanzixizuoye_one.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wanzixizuoye_one.R;
import com.example.wanzixizuoye_one.adapter.FenLeiAdapter;
import com.example.wanzixizuoye_one.bean.FenLeiBean;
import com.example.wanzixizuoye_one.presenter.MainPresenterlist;
import com.example.wanzixizuoye_one.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends Fragment implements MainView {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    @BindView(R.id.title)
    TextView title;
    private List<FenLeiBean.DataBean.CurrentCategoryBean.SubCategoryListBean> beanList;
    private FenLeiAdapter adapter;
    private String id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        MainPresenterlist presenterlist = new MainPresenterlist(this);
        presenterlist.getTabData(id);
    }

    private void initView() {

        Bundle arguments = getArguments();
        id = arguments.getString("id", 0 + "");


        rv.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        beanList = new ArrayList<>();

        adapter = new FenLeiAdapter(getActivity(), beanList);
        rv.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void OnSuccess(FenLeiBean fenLeiBean) {
        if (fenLeiBean != null) {
            List<FenLeiBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = fenLeiBean.getData().getCurrentCategory().getSubCategoryList();
            FenLeiBean.DataBean.CurrentCategoryBean currentCategory = fenLeiBean.getData().getCurrentCategory();

            beanList.addAll(subCategoryList);

            if (currentCategory != null) {
                text.setText("-----" + currentCategory.getName() + "分类-----");
                title.setText(currentCategory.getFront_name());
                Glide.with(getActivity()).load(currentCategory.getWap_banner_url()).into(img);
            }
        }
//        beanList.addAll(fenLeiBean.getData().getCurrentCategory().getSubCategoryList());


        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
