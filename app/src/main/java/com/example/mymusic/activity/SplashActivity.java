package com.example.mymusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.mymusic.R;

/**
 * 启动界面
 */
public class SplashActivity extends AppCompatActivity {
    private static final String TAG="SplashActivity";
    /**
     * 下一步常量
     */
    private static final int MESSAGE_NEXT=100;
    /**
     * 默认延时时间
     */
    private static final long DEFAULT_DELAY_TIME=3000;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            switch (msg.what){
                case MESSAGE_NEXT:
                    next();
                    break;
                    
            }
            
        }
    };
    private void next()
    {
        Log.e(TAG,"next");
        /*
        //创建intent
        Intent intent =new Intent(this,GuideActivity.class);
        startActivity(intent);
        //关闭当前界面
        finish();
         */
        startActivityAfterFinishThis(GuideActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置界面全屏
        //获取decorView
        View decorView=getWindow().getDecorView();
        //判断版本
        if(Build.VERSION.SDK_INT>11&&Build.VERSION.SDK_INT<19)
        {
            //11-18
            decorView.setSystemUiVisibility(View.GONE);
        }else if(Build.VERSION.SDK_INT>=19)
        {
            //19以及以上版本
            //SYSTEM_UI_FLAG_HIDE_NAVIGATION:隐藏导航栏
            //SYSTEM_UI_FLAG_IMMERSIVE_STICKY:从状态栏下拉会半透明悬浮显示一会儿状态栏和导航栏
            //SYSTEM_UI_FALG_FUULLSCREEN:全屏
            int options=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            //设置到控件
            decorView.setSystemUiVisibility(options);
        }
        //延时3秒
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            handler.sendEmptyMessage(MESSAGE_NEXT);
            }
        },DEFAULT_DELAY_TIME);
    }

    /**
     * 启动界面
     * @param clazz
     */
    private void startActivity(Class<?> clazz)
    {
        Intent intent =new Intent(this,clazz);
        startActivity(intent);
    }
    /**
     * 启动界面并关闭当前界面
     */
    private void startActivityAfterFinishThis(Class<?> clazz)
    {
        startActivity(clazz);
        finish();
    }
}