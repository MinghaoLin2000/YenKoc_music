package com.example.mymusic;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.example.mymusic.util.ToastUtil;

import es.dmoral.toasty.Toasty;

public class AppContext extends Application {
    //创建了

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化工具类
        Toasty.Config.getInstance().apply();
        //初始化
        ToastUtil.init(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
