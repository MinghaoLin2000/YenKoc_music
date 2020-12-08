package com.example.mymusic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mymusic.R;
import com.example.mymusic.util.LogUtil;
import com.example.mymusic.util.StringUtil;
import com.example.mymusic.util.ToastUtil;

import org.apache.commons.lang3.StringUtils;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

/**
 * 登陆界面
 */
public class LoginActivity extends BaseTitleActivity{
    private static final String TAG ="LoginActivity" ;
    //用户名输入框
    @BindView(R.id.et_username)
    EditText et_username;
    //密码输入框
    @BindView(R.id.et_password)
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //登陆按钮点击
    @OnClick(R.id.bt_login)
    public void onLoginClick()
    {
        LogUtil.d(TAG, "onLoginClick:");
        //获取用户名
        String username=et_username.getText().toString().trim();
        if(StringUtils.isBlank(username))
        {
            LogUtil.d(TAG,"conLoginClick user empty");
            //Toast.makeText(getMainActivity(),R.string.enter_username,Toast.LENGTH_SHORT).show();
            ToastUtil.errorShortToast(R.string.enter_username);
        }
        //如果用户名不是手机号也不是邮箱
        //就是格式错误
        if(!(StringUtil.isPhone(username)||StringUtil.isEmail(username)))
        {
            ToastUtil.errorShortToast(R.string.error_username_format);
            return;
        }
        //获取密码
        String password=et_password.getText().toString().trim();
       if(!StringUtil.isPassword(password))
       {
           ToastUtil.errorShortToast(R.string.error_password_format);
       }
        //调用登陆方法
        ToastUtil.successShortToast(R.string.login_success);
    }
    //忘记密码按钮点击
    @OnClick(R.id.bt_forget)
    public void onForgetPasswordClick()
    {
        LogUtil.d(TAG, "onForgetPasswordClick");
    }

}