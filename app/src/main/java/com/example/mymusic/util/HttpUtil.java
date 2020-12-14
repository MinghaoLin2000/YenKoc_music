package com.example.mymusic.util;

import android.text.TextUtils;

import com.example.mymusic.R;
import com.example.mymusic.domain.response.BaseResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

public class HttpUtil {
    public static <T> void handlerRequest(Object data, Throwable e) {
        //判断错误类型
        if (e instanceof UnknownHostException) {
            ToastUtil.errorShortToast(R.string.error_network_unknown_host);
        } else if (e instanceof ConnectException) {
            ToastUtil.errorShortToast(R.string.error_network_connect);
        } else if (e instanceof SocketTimeoutException) {
            ToastUtil.errorShortToast(R.string.error_network_timeout);
        } else if (e instanceof HttpException) {
            HttpException exception = (HttpException) e;

            //获取响应码
            int code = exception.code();

            if (code == 401) {
                ToastUtil.errorShortToast(R.string.error_network_not_auth);
            } else if (code == 403) {
                ToastUtil.errorShortToast(R.string.error_network_not_permission);
            } else if (code == 404) {
                ToastUtil.errorShortToast(R.string.error_network_not_found);
            } else if (code >= 500) {
                ToastUtil.errorShortToast(R.string.error_network_server);
            } else {
                ToastUtil.errorShortToast(R.string.error_network_unknown);
            }
        } else {
            if (data instanceof BaseResponse) {
                BaseResponse response = (BaseResponse) data;

                if (TextUtils.isEmpty(response.getMessage())) {
                    ToastUtil.errorShortToast(R.string.error_network_unknown);
                } else {
                    //有错误提示
                    ToastUtil.errorShortToast(response.getMessage());
                }
            }
        }
    }
}
