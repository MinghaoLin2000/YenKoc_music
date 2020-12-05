package com.example.mymusic.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 偏好设计工具类
 * 是否登陆，是否显示引导界面，用户id
 */
public class PreferenceUtil {
    private static final String NAME="ixuea_my_cloud_music";
    /**
     * 是否显示引导界面的key
     */
    private static final String SHOW_GUIDE="SHOW_GUIDE";
    /**实例
     *
     */
    private static PreferenceUtil instance;
    /**
     * 上下文
     */
    private final Context context;
    private final SharedPreferences preference;

    /**
     * 构造方法
     * @param context
     */
    public PreferenceUtil(Context context)
    {
        //保存上下文，这样写可以保证内存不会泄露
        this.context=context.getApplicationContext();

        //获取偏好设置
        preference=this.context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        //
    }

    /**
     * 获取偏好设置单例
     * @param context
     * @return
     */
    public static PreferenceUtil getInstance(Context context)
    {
        if(instance==null)
        {
            instance=new PreferenceUtil(context);
        }
        return instance;
    }

    /**
     * 是否显示引导界面
     * @return
     */
    public boolean isShowGuide()
    {
        return preference.getBoolean(SHOW_GUIDE,true);
    }

    /**
     * 设置是否显示引导界面
     * @param value
     */
    public void setShowGuide(boolean value)
    {
        preference.edit().putBoolean(SHOW_GUIDE,value).commit();
    }


}
