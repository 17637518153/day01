package com.example.lianxi.model;

import com.example.lianxi.bean.MainBean;


public interface ICallback {
    void OnSuccess(MainBean mainBean);

    void OnFail(String error);
}
