package com.example.mymusic.domain.response;
/**
 * 通用网络请求响应模型
 */
public class BaseResponse {
    /**
     * 状态码，只有发生错误了才有值
     */
    private Integer status;
    /**
     *  出错的提示信息
     *  发生了错误不一定有
     */
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
