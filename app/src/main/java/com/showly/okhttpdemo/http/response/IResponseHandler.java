package com.showly.okhttpdemo.http.response;

/**
 * 回调接口父类
 */
public interface IResponseHandler {

    void onFailure(int statusCode, String error_msg);

    void onProgress(long currentBytes, long totalBytes);
}
