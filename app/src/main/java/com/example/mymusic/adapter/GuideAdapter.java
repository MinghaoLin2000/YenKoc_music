package com.example.mymusic.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mymusic.R;
import com.example.mymusic.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导界面适配器
 */
public class GuideAdapter extends FragmentPagerAdapter {
    /*
    列表数据源
     */
    protected List<Integer> datum=new ArrayList<>();
    /**
     *构造方法
     */
    public GuideAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    /**
     * 返回当前位置的Fragment
     * @param position
     * @return
     */

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return GuideFragment.newInstance(getData(position));
    }

    /**
     * 获取当前位置
     * @param position
     * @return
     */
    private int getData(int position) {
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
    public void setDatum(List<Integer> datum)
    {
        if(datum!=null&&datum.size()>0)
        {
            this.datum.clear();
            this.datum.addAll(datum);
            //通知数据改变了
            notifyDataSetChanged();
        }
    }
}
