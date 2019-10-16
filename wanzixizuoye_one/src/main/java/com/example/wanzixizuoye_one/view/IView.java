package com.example.wanzixizuoye_one.view;

import com.example.wanzixizuoye_one.bean.MainBean;

public interface IView {
    void OnSuccess(MainBean mainBean);
    void OnFail(String error);
}
