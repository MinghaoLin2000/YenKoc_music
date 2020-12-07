package com.example.mymusic.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用的FragmentPagerAdapter
 * 主要是创建了列表
 * 实现了通用的方法
 *
 */
public abstract class BaseFragmentPagerAdapter<T> extends FragmentPagerAdapter {
    protected final Context context;
    /*
       列表数据源
        */
    protected List<T> datum=new ArrayList<>();
    /**
     * 构造方法
     * @param fm
     */
    public BaseFragmentPagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        this.context=context;
    }

    /**
     * 返回当前列表的Fragment
     * @param position
     * @return
     */
    @NonNull
    @Override
    public abstract Fragment getItem(int position);
    /**
     * 获取当前位置
     * @param position
     * @return
     */
    public T getData(int position) {
        return datum.get(position);
    }

    /**
     * 返回有多少个
     * @param
     * @return
     */
    @Override
    public int getCount() {
        return datum.size();
    }

    /**
     * 设置数据
     * @param datum
     */
    public void setDatum(List<T> datum)
    {
        if(datum!=null&&datum.size()>0)
        {
            this.datum.clear();
            this.datum.addAll(datum);
            //通知数据改变了
            notifyDataSetChanged();
        }
    }
    /**
     * 加载数据
     * @param datum
     */
    public void addDatum(List<T> datum)
    {
        if(datum!=null&&datum.size()>0)
        {
            this.datum.addAll(datum);
            //通知数据改变了
            notifyDataSetChanged();
        }
    }
}
