package com.example.wanzixizuoye_one.model;

import com.example.wanzixizuoye_one.bean.FenLeiBean;

public interface MainCallback {
    void OnSuccess(FenLeiBean fenLeiBean);

    void OnFail(String error);
}
