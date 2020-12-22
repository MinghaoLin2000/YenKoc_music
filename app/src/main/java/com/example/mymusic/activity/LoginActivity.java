package com.example.mymusic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mymusic.MainActivity;
import com.example.mymusic.MusicActivity;
import com.example.mymusic.R;
import com.example.mymusic.api.Api;
import com.example.mymusic.api.Service;
import com.example.mymusic.db.DBHelper;
import com.example.mymusic.domain.Sheet;
import com.example.mymusic.domain.SheetDetailWrapper;
import com.example.mymusic.domain.SheetListWrapper;
import com.example.mymusic.domain.response.DetailResponse;
import com.example.mymusic.domain.response.ListResponse;
import com.example.mymusic.listener.HttpObserver;
import com.example.mymusic.listener.ObserverAdapter;
import com.example.mymusic.util.Constant;
import com.example.mymusic.util.LoadingUtil;
import com.example.mymusic.util.LogUtil;
import com.example.mymusic.util.StringUtil;
import com.example.mymusic.util.ToastUtil;

import org.apache.commons.lang3.StringUtils;

import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
        if(!(StringUtil.isPhone(username)))
        {
            ToastUtil.errorShortToast(R.string.error_phone_format);
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
        DBHelper dbHelper=new DBHelper("music.db",this,1);

        SQLiteDatabase db=dbHelper.getReadableDatabase();
        db=dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where phone = ? ", new String[]{username});
        String password_try = null;

        while(cursor.moveToNext())
        {
            password_try=cursor.getString(cursor.getColumnIndex("password"));
        }
        if(password.equals(password_try))
        {
            Log.d(TAG, "onLoginClick: login success");
            startActivity(MusicActivity.class);
        }



    }
    //忘记密码按钮点击
    @OnClick(R.id.bt_forget)
    public void onForgetPasswordClick()
    {
        LogUtil.d(TAG, "onForgetPasswordClick");
    }



}