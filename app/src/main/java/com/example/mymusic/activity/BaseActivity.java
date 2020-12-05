package com.example.mymusic.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 通用类
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * 找控件
     */
    protected void initViews(){

    }

    /**
     * 设置数据
     */
    protected void initDatum(){

    }
    /**
     * 设置监听器
     */
    protected void initListeners()
    {

    }

    /**
     * 在onCreate方法后面进行调用
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initViews();
        initDatum();
        initListeners();
    }
}
