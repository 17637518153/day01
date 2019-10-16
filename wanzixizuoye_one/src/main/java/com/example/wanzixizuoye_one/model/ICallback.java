package com.example.wanzixizuoye_one.model;

import com.example.wanzixizuoye_one.bean.MainBean;

public interface ICallback {
    void OnSuccess(MainBean mainBean);
    void OnFail(String error);
}
