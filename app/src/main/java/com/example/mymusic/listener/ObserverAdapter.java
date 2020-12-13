package com.example.mymusic.listener;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class ObserverAdapter<T> implements Observer<T> {
    /**
     * 开始定义了执行
     * @param d
     */
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    /**
     * 当前Observer执行结束
     * @param t
     */
    @Override
    public void onNext(@NonNull T t) {

    }

    /**
     * 执行失败
     * @param e
     */
    @Override
    public void onError(@NonNull Throwable e) {

    }

    /**
     * 调用了onNext方法后调用
     */
    @Override
    public void onComplete() {

    }
}
