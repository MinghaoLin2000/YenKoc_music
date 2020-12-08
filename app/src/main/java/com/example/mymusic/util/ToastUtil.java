package com.example.mymusic.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import es.dmoral.toasty.Toasty;

public class ToastUtil {
    public static void errorShortToast(@NonNull Context context, @StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_SHORT).show();

    }


    public static void errorLongToast(@NonNull Context context,@StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_LONG).show();
    }
    public static void successShortToast(@NonNull Context context,@StringRes int id) {
        Toasty.success(context,id,Toasty.LENGTH_SHORT).show();
    }
}
