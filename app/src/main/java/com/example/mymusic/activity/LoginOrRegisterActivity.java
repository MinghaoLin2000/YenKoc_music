package com.example.mymusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mymusic.R;
/**
 * 登陆注册界面
 */
public class LoginOrRegisterActivity extends BaseCommonActivity implements View.OnClickListener {
    private static final String TAG= "LoginOrRegisterActivity";
    /**
     * 登陆按钮
     */
    private Button bt_login;
    /**
     * 注册按钮
     */
    private Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
    }

    @Override
    protected void initViews() {
        super.initViews();
        //登陆按钮
        bt_login=findViewById(R.id.bt_login);
        //注册按钮
        bt_register = findViewById(R.id.bt_register);
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        //登陆按钮
        bt_login.setOnClickListener(this);
        //注册按钮
        bt_register.setOnClickListener(this);

    }

    /**
     * 点击回调方法
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_login:
                //登陆按钮
                Log.d(TAG, "onClick login");
                startActivityAfterFinishThis(LoginActivity.class);
                break;
            case R.id.bt_register:
                //登陆按钮
                Log.d(TAG, "onClick register");
                break;

        }

    }
}