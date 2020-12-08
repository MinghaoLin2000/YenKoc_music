package com.example.mymusic;

import android.app.Application;

import es.dmoral.toasty.Toasty;

public class AppContext extends Application {
    //创建了

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化工具类
        Toasty.Config.getInstance().apply();
    }
}
