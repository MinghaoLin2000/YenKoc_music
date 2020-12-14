package com.example.mymusic.listener;

import android.icu.text.UnicodeSetIterator;
import android.text.TextUtils;

import com.example.mymusic.R;
import com.example.mymusic.domain.response.BaseResponse;
import com.example.mymusic.util.HttpUtil;
import com.example.mymusic.util.LogUtil;
import com.example.mymusic.util.ToastUtil;

import org.w3c.dom.Text;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import retrofit2.HttpException;

/**
 * 网路请求Observer
 * @param <T>
 */
public abstract class HttpObserver<T> extends ObserverAdapter<T> {
    private static final String TAG ="HttpObserver" ;

    /**
     * 请求成功
     * @param data
     */
    public abstract void onSucceeded(T data);

    /**
     * 请求失败
     * @param data
     * @param e
     */
    public boolean onFailed(T data,Throwable e)
    {
        return false;
    }

    public void onNext(T t)
    {
        super.onNext(t);
        LogUtil.d(TAG,"onNext:"+t);
        if(isSucceeded(t))
        {
            onSucceeded(t);
        }else {
            //请求出错
            handlerRequest(t,null);
            
        }
        //请求正常
        onSucceeded(t);
    }

    /**
     * 网络请求是否成功
     * @param t
     * @return
     */

    private boolean isSucceeded(T t) {
        if(t instanceof BaseResponse)
        {
            //判断具体的业务请求是否成功
            BaseResponse response=(BaseResponse)t;
            //没有状态码表示成功
            //这是我们和服务端的一个规定
            return response.getStatus()==null;
        }
        return false;
    }


    @Override
    public void onError(@NonNull Throwable e) {
        super.onError(e);
        LogUtil.d(TAG,"onError:"+e.getLocalizedMessage());
        //TODO 处理错误
        handlerRequest(null,e);

    }
    private void handlerRequest(T data, Throwable e)
    {
        if(onFailed(data,e))
        {
            //回调了请求失败方法
            //并且该方法返回了true

            //返回true就表示外部手动处理错误
            //那我们框架内部就不用做任何事情了
        }else {
            HttpUtil.handlerRequest(data,e);
        }
    }
}
