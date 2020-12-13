package com.example.mymusic.listener;

import com.example.mymusic.util.LogUtil;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

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
        //TODO 处理错误
        //请求正常
        onSucceeded(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        super.onError(e);
        LogUtil.d(TAG,"onError:"+e.getLocalizedMessage());
        //TODO 处理错误

    }
}
