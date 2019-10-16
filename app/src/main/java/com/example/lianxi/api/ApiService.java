package com.example.lianxi.api;

import com.example.lianxi.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    //https://cdwan.cn/index
    String MainUrl = "https://cdwan.cn/";
    @GET("index")
    Observable<MainBean> getMainData();
}
