package com.example.wanzixizuoye_one.presenter;

import com.example.wanzixizuoye_one.bean.MainBean;
import com.example.wanzixizuoye_one.model.ICallback;
import com.example.wanzixizuoye_one.model.IModellist;
import com.example.wanzixizuoye_one.view.IView;

public class IPresenterlist implements IPresenterjiekou {


    private final IModellist modellist;
    IView view;

    public IPresenterlist(IView view) {
        this.view = view;
        modellist = new IModellist();
    }

    @Override
    public void getTabData() {
        modellist.getTabData(new ICallback() {
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
