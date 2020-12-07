package com.example.mymusic.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mymusic.activity.BaseCommonActivity;
import com.example.mymusic.util.PreferenceUtil;

public abstract class BaseCommonFragment extends BaseFragment {
    protected PreferenceUtil sp;

    protected void initDatum()
    {
        super.initDatum();
        //初始化偏好设置工具类
        sp=PreferenceUtil.getInstance(getMainActivity());
    }
    protected BaseCommonActivity getMainActivity()
    {
        return (BaseCommonActivity)getActivity();
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
        getMainActivity().finish(); //只有在界面上才有这个功能
    }

}
