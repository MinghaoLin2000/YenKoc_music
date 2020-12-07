package com.example.mymusic.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymusic.MainActivity;
import com.example.mymusic.R;
import com.example.mymusic.fragment.GuideFragment;
import com.example.mymusic.util.PreferenceUtil;

public class GuideActivity extends BaseCommonActivity implements View.OnClickListener {
    private Button bt_login_or_register;
    private Button bt_enter;
    private static final String TAG="GuideActivity";
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
        //找控件
        //登陆注册按钮
        bt_login_or_register=findViewById(R.id.bt_login_or_register);
        //立即体验按钮
        bt_enter = findViewById(R.id.bt_enter);
        //测试显示fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, GuideFragment.newInstance()).commit();
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
