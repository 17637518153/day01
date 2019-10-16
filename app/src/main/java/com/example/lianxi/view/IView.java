package com.example.lianxi.view;

import com.example.lianxi.bean.MainBean;


public interface IView {
    void OnSuccess(MainBean mainBean);

    void OnFail(String error);
}
