package com.example.lianxi.presenter;

import com.example.lianxi.bean.MainBean;
import com.example.lianxi.model.ICallback;
import com.example.lianxi.model.IMoldellist;
import com.example.lianxi.view.IView;

import java.util.List;

public class IPresenterlist implements IPresenterjiekou {


    private final IMoldellist iMoldellist;
    IView view;

    public IPresenterlist(IView view) {
        this.view = view;
        iMoldellist = new IMoldellist();
    }

    @Override
    public void getMainData() {
        iMoldellist.getMainData(new ICallback() {
            @Override
            public void OnSuccess(MainBean mainBean) {
                view.OnSuccess(mainBean);
            }

            @Override
            public void OnFail(String error) {
                view.OnFail(error);
            }
        });
    }
}
