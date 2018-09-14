# OkHttpUtils
okhttp3.0的封装使用

一、OkHttp导包：

    compile 'com.squareup.okhttp3:okhttp:3.4.1'
    compile 'com.squareup.okio:okio:1.9.0'
    compile 'com.google.code.gson:gson:2.3.1'
    
    
二、OKhttp工具类使用
这里演示POST、GET请求方式，以Gson解析数据类型

注：使用不同的解析方式的时候，根据需求选用不同的回调接口：GsonResponseHandler(Gson解析，返回对象数据)，RawResponseHandler(返回字符串数据)、JsonResponseHandler(返回JSONObject数据)、DownloadResponseHandler(返回File数据类型)

1.Post请求(使用Gson解析数据)

        Map<String, String> params = new HashMap<>();
        params.put("phone", "13512345678");

        OkHttpUtils.get().post(MainActivity.this, http://192.168.1.102:8066/loginapi/shortmsg/getShortMsg.do, params, new GsonResponseHandler<MobileCaptcha>() {
            @Override
            public void onSuccess(int statusCode, MobileCaptcha response) {
                Log.i("MainActivity=22=", statusCode + "----" + response.getStatus() + "---" + response.getMsg());
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                Log.i("MainActivity=22=", statusCode + "---" + error_msg);
            }
        });



2.Get请求(使用Gson解析数据)

Map<String, String> map = new HashMap<>();
        map.put("phone", "13512345678");

        OkHttpUtils.get().get(MainActivity.this, http://192.168.1.102:8066/loginapi/shortmsg/getShortMsg.do, map, new GsonResponseHandler<MobileCaptcha>() {
            @Override
            public void onSuccess(int statusCode, MobileCaptcha response) {
                Log.i("MainActivity=11=", statusCode + "----" + response.getStatus() + "---" + response.getMsg());
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                Log.i("MainActivity=11=", statusCode + "---" + error_msg);
            }
        });
