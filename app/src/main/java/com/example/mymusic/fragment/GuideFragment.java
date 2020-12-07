package com.example.mymusic.fragment;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mymusic.R;
import com.example.mymusic.activity.BaseCommonActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuideFragment extends BaseCommonFragment {
    /**
     * 图片控件
     */
    private ImageView iv;

    public GuideFragment() {
        // Required empty public constructor
    }

    /**
     *  创建方法
     * @return
     */
    public static GuideFragment newInstance(int id) {
        //创建fragment
        GuideFragment fragment = new GuideFragment();
        //创建Bundle
        Bundle args = new Bundle();
        //添加
        args.putInt(Constant.ID,id);
        //将Bundle设置到fragment
        fragment.setArguments(args);
        return fragment;
    }
    /**
     * 返回要显示的View
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    protected View getLayoutView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guide, container, false);
    }
    protected void initViews()
    {
        super.initViews();
        iv=findViewById(R.id.iv);
    }
    protected void initDatum()
    {
        super.initDatum();
        //取出传递的数据
        int id=getArguments().getInt(Constant.ID,-1);
        //判断数据格式
        if(id==-1)
        {
            //数据有问题
            getActivity().finish();
            return;
        }
        //显示图片
        iv.setImageResource(id);
    }
}