package com.example.lianxi.model;

import com.example.lianxi.api.ApiService;
import com.example.lianxi.bean.MainBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IMoldellist implements IModeljiekou {
    @Override
    public void getMainData(final ICallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.MainUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getMainData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainBean mainBean) {

//                        List<MainBean.DataBean.BrandListBean> brandList = mainBean.getData().getBrandList();
                        callback.OnSuccess(mainBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.OnFail("获取数据失败!!!");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
