package com.example.mymusic.domain.response;

import java.util.List;

public class ListResponse<T> extends BaseResponse {
    /**
     * 定义一个列表
     * 里面的对象使用了泛型
     */
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
