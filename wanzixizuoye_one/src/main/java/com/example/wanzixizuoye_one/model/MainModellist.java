package com.example.wanzixizuoye_one.model;

import com.example.wanzixizuoye_one.api.MainApiService;
import com.example.wanzixizuoye_one.bean.FenLeiBean;
import com.example.wanzixizuoye_one.bean.MainBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModellist implements MainModeljiekou {
    @Override
    public void getMainData(final MainCallback callback, String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainApiService.MAINURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MainApiService service = retrofit.create(MainApiService.class);

        service.getFenData(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FenLeiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FenLeiBean fenLeiBean) {
                        if (fenLeiBean != null) {
                            callback.OnSuccess(fenLeiBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.OnFail("获取数据失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
