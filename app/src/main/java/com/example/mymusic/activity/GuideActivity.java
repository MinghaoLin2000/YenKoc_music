package com.example.mymusic.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mymusic.MainActivity;
import com.example.mymusic.R;
import com.example.mymusic.adapter.GuideAdapter;
import com.example.mymusic.fragment.GuideFragment;
import com.example.mymusic.util.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class GuideActivity extends BaseCommonActivity implements View.OnClickListener {
    private Button bt_login_or_register;
    private Button bt_enter;
    private static final String TAG="GuideActivity";
    /**
     * 左右滚动控件
     */
    private ViewPager vp;
    /**
     * 适配器
     */
    private GuideAdapter adapter;
    /**
     * 指示器
     */
    private CircleIndicator ci;

    /**
     * 当界面创建时，回调该函数
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }

    @Override
    protected void initViews() {
        super.initViews();
        //隐藏状态栏
        hideStatsuBar();
        //ViewPager控件
        vp=findViewById(R.id.vp);
        //指示器
        ci=findViewById(R.id.ci);
        //找控件
        //登陆注册按钮
        bt_login_or_register=findViewById(R.id.bt_login_or_register);
        //立即体验按钮
        bt_enter = findViewById(R.id.bt_enter);
        //测试显示fragment
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, GuideFragment.newInstance(R.drawable.guide1)).commit();
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        //创建适配器
        adapter=new GuideAdapter(getMainActivity(),getSupportFragmentManager());
        //设置适配器到控件
        vp.setAdapter(adapter);
        //让指示器根据列表控件配合工作
        ci.setViewPager(vp);
        //适配器注册数据源观察者
        adapter.registerDataSetObserver(ci.getDataSetObserver());
        //准备数据
        List<Integer> datum=new ArrayList<>();
        datum.add(R.drawable.guide1);
        datum.add(R.drawable.guide2);
        datum.add(R.drawable.guide3);
        datum.add(R.drawable.guide4);
        datum.add(R.drawable.guide5);
        //设置数据到适配器
        adapter.setDatum(datum);
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        //设置点击事件
        bt_login_or_register.setOnClickListener(this);
        //立即体验按钮
        bt_enter.setOnClickListener(this);
    }

    /**
     * 点击回调
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_login_or_register:
                //登陆按钮点击
                Log.d(TAG, "onClick: login or register");
                startActivityAfterFinishThis(LoginOrRegisterActivity.class);
                setShowGuide();
                break;
            case R.id.bt_enter:
                //立即体验按钮点击
                Log.d(TAG, "onClick: enter");
                startActivityAfterFinishThis(MainActivity.class);
                setShowGuide();
                break;
        }

    }

    private void setShowGuide() {
        sp.setShowGuide(false);
    }
}
