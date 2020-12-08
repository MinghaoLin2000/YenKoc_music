package com.example.mymusic.util;

import android.util.Log;

import com.example.mymusic.BuildConfig;

//对android日志api做一层封装
public class LogUtil {
    //是否是调试状态
    private static boolean isDebug= BuildConfig.DEBUG;
    //调试级别日志
    public static void d(String tag,String value)
    {
        if(isDebug)
        {
            Log.d(tag,value);
        }
    }

    //警告级别日志
    public static void w(String tag,String value)
    {
        if(isDebug)
        {
            Log.w(tag,value);
        }
    }
}
