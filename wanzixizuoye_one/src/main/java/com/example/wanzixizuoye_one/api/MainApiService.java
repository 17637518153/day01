package com.example.demo2.api;

import com.example.wanzixizuoye_one.bean.FenLeiBean;
import com.example.wanzixizuoye_one.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApiService {

    String MAINURL = "https://cdwan.cn/api/";
    @GET("catalog/index")
    Observable<MainBean> getTabData();


    @GET("catalog/current")
    Observable<FenLeiBean> getFenData(@Query("id") String id);


}
