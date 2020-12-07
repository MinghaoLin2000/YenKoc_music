package com.example.mymusic.activity;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import com.example.mymusic.util.PreferenceUtil;

public class BaseCommonActivity extends BaseActivity {
    /**
     * 偏好设置实例
     *
     */
    protected PreferenceUtil sp;
    @Override
    protected void initDatum() {
        super.initDatum();
        //初始化偏好设置
        sp=PreferenceUtil.getInstance(getMainActivity());
    }

    /**
     * 隐藏虚拟按键并全屏
     */
    protected void fullScreen()
    {
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
    }
    /**
     * 隐藏状态栏
     *
     */
    protected void hideStatsuBar()
    {
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    /**
     * 启动界面
     * @param clazz
     */
    protected void startActivity(Class<?> clazz)
    {
        Intent intent =new Intent(getMainActivity(),clazz);
        startActivity(intent);
    }
    /**
     * 启动界面并关闭当前界面
     */
    protected void startActivityAfterFinishThis(Class<?> clazz)
    {
        startActivity(clazz);
        finish();
    }
    /**
     * 获取界面
     */
    protected BaseCommonActivity getMainActivity()
    {
        return this;
    }
}