package com.example.mymusic.domain.response;

public class DetailResponse<T> extends BaseResponse {
    /**
     * 真实的数据
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
