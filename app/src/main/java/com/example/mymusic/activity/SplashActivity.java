package com.example.mymusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
public class SplashActivity extends BaseCommonActivity {
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
        if(sp.isShowGuide()){
            startActivityAfterFinishThis(GuideActivity.class);
        }else
        {
            startActivityAfterFinishThis(LoginOrRegisterActivity.class);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        fullScreen();
        //延时3秒
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            handler.sendEmptyMessage(MESSAGE_NEXT);
            }
        },DEFAULT_DELAY_TIME);
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        /*
        //测试使用偏好设置
        //获取偏好设置类
        SharedPreferences preferences=getSharedPreferences("ixuea",MODE_PRIVATE);
        //保存一个字符串"我们是爱学啊"
        preferences.edit().putString("username","我们是爱学啊").commit();
        //获取保存的值
        String username=preferences.getString("username",null);
        //打印
        Log.d(TAG, "initDatum: "+username);
        //删除
        preferences.edit().remove("username").commit();
        //再次获取值
        username=preferences.getString("username",null);
        //打印
        Log.d(TAG, "initDatum: "+username);

         */
    }
}