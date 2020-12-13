package com.example.mymusic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mymusic.R;
import com.example.mymusic.api.Api;
import com.example.mymusic.api.Service;
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
        /*

        //请求歌单详情
        service.sheetDetail("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SheetDetailWrapper>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SheetDetailWrapper sheetDetailWrapper) {
                            LogUtil.d(TAG,"request sheet detail success:"+sheetDetailWrapper.getData().getTitle());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        LogUtil.d(TAG,"request sheet detail error:"+e.getLocalizedMessage());
                        //判断错误类型
                        if(e instanceof UnknownHostException)
                        {
                            ToastUtil.errorShortToast(R.string.error_network_unknown_host);
                        }else if(e instanceof ConnectException)
                        {
                            ToastUtil.errorShortToast(R.string.error_network_connect);
                        }else if(e instanceof SocketTimeoutException)
                        {
                            ToastUtil.errorShortToast(R.string.error_network_timeout);
                        }else if(e instanceof HttpException)
                        {
                            HttpException exception=(HttpException)e;
                            //获取响应码
                            int code=exception.code();
                            if(code ==401)
                            {
                             ToastUtil.errorShortToast(R.string.error_network_not_auth);
                            }else if(code==403)
                            {
                                ToastUtil.errorShortToast(R.string.error_network_not_permission);

                            }else if(code==404)
                            {
                                ToastUtil.errorShortToast(R.string.error_network_not_found);
                            }else if(code>500)
                            {
                                ToastUtil.errorShortToast(R.string.error_network_server);
                            }else
                            {
                                ToastUtil.errorShortToast(R.string.error_network_unknown);

                            }
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });

         */
        /*
        //使用重构后的api
        Api.getInstance().sheetDetail("1").subscribe(new Observer<SheetDetailWrapper>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LogUtil.d(TAG,"onSubscibe");
                //显示加载提示框
                LoadingUtil.showLoading(getMainActivity());
            }

            @Override
            public void onNext(@NonNull SheetDetailWrapper sheetDetailWrapper) {
                LogUtil.d(TAG,"onNext");
                //隐藏加载提示框
                LoadingUtil.hideLoading();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.d(TAG,"onError");
                //隐藏加载提示框
                LoadingUtil.hideLoading();
            }

            @Override
            public void onComplete() {
                LogUtil.d(TAG,"onComplete");
            }
        });

         */
        /*
        //测试加载提示框
        LoadingUtil.showLoading(getMainActivity());
        //3秒后隐藏
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadingUtil.hideLoading();
            }
        },3000);

         */
        /*
        //请求歌单列表
        Api.getInstance().sheets()
                .subscribe(new Observer<SheetListWrapper>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SheetListWrapper sheetListWrapper) {
                        LogUtil.d(TAG,"onNext:"+sheetListWrapper.getData().size());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

         */
        /*
        Api.getInstance().sheetDetail("1").subscribe(new Observer<DetailResponse<Sheet>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull DetailResponse<Sheet> sheetDetailResponse) {
        LogUtil.d(TAG,"onNext:"+sheetDetailResponse.getData().getTitle());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        */
        /*
        //使用ListResponse
        Api.getInstance().sheets().subscribe(new Observer<ListResponse<Sheet>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ListResponse<Sheet> sheetListResponse) {
                LogUtil.d(TAG,"onNext:"+sheetListResponse.getData().size());

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

         */
        /*
        //使用ObserverAdapter
        Api.getInstance().sheetDetail("1").subscribe(new ObserverAdapter<DetailResponse>(){
            @Override
            public void onNext(@NonNull DetailResponse detailResponse) {
                super.onNext(detailResponse);
            }
        });
        */

         Api.getInstance().sheetDetail("1").subscribe(new HttpObserver<DetailResponse<Sheet>>(){

             @Override
             public void onSucceeded(DetailResponse<Sheet> data) {
                 Log.d(TAG, "onSucceeded: "+data.getData().getTitle());
             }
         });
        /*
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

         */
    }
    //忘记密码按钮点击
    @OnClick(R.id.bt_forget)
    public void onForgetPasswordClick()
    {
        LogUtil.d(TAG, "onForgetPasswordClick");
    }



}