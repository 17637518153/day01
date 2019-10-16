package com.example.wanzixizuoye_one.presenter;

import com.example.wanzixizuoye_one.bean.FenLeiBean;
import com.example.wanzixizuoye_one.bean.MainBean;
import com.example.wanzixizuoye_one.model.MainCallback;
import com.example.wanzixizuoye_one.model.MainModellist;
import com.example.wanzixizuoye_one.view.MainView;

public class MainPresenterlist implements MainPresenterjiekou {


    private final MainModellist modellist;
    MainView view;

    public MainPresenterlist(MainView view) {
        this.view = view;
        modellist = new MainModellist();
    }

    @Override
    public void getTabData(String id) {
        modellist.getMainData(new MainCallback() {

            @Override
            public void OnSuccess(FenLeiBean fenLeiBean) {
                if (fenLeiBean != null) {

                    view.OnSuccess(fenLeiBean);
                }
            }

            @Override
            public void OnFail(String error) {
                if (view != null) {

                    view.OnFail(error);
                }
            }
        }, id);
    }
}
