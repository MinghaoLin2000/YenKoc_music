package com.example.mymusic.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import es.dmoral.toasty.Toasty;

public class ToastUtil {
    /**
     * 上下文
     */
    private static Context context;
    /**
     * 初始化方法
     * @param context
     */
    public static void init(Context context) {
        ToastUtil.context=context;

    }
    public static void errorShortToast(@StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_SHORT).show();

    }


    public static void errorLongToast(@StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_LONG).show();
    }
    public static void successShortToast(@StringRes int id) {
        Toasty.success(context,id,Toasty.LENGTH_SHORT).show();
    }


}
