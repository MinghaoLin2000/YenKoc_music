package com.example.mymusic.util;

import android.app.Activity;
import android.app.ProgressDialog;

import com.example.mymusic.R;
import com.example.mymusic.activity.BaseCommonActivity;

public class LoadingUtil {

    private static ProgressDialog progressDialog;

    /**
     * 显示一个加载对话框,使用默认文字
     * @param activity
     */

    public static void showLoading(Activity activity)
    {
        showLoading(activity,activity.getString(R.string.loading));

    }

    /**
     * 显示一个加载对话框
     */
    public static void showLoading(Activity activity,String message)
    {
        //activity为空或者已经被销毁
        if(activity==null||activity.isFinishing())
        {
            return;
        }
        //判断是否显示
        if(progressDialog!=null)
        {
            //已经显示了
            //就不在显示
            return;
        }
        //创建一个进度对话框
        progressDialog=new ProgressDialog(activity);
        //提示标题
        progressDialog.setTitle("提示");
        //提示信息
        progressDialog.setMessage(message);
        //点击弹窗外部不会自动隐藏
        progressDialog.setCancelable(false);
        //显示
        progressDialog.show();

    }

    /**
     * 隐藏加载提示对话框
     */
    public static void hideLoading()
    {
        if(progressDialog!=null|| progressDialog.isShowing())
        {
            progressDialog.hide();
            progressDialog=null;
        }

    }
}
