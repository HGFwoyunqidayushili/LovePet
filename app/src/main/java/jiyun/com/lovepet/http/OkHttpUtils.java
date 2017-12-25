package jiyun.com.lovepet.http;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 *
 * Created by lenovo on 2017/11/1.
 */

public class OkHttpUtils  {
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient okHttpClient;
    private OkHttpUtils(){
       okHttpClient=new OkHttpClient();
    }
    public static OkHttpUtils getInstance(){
        if (okHttpUtils!=null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils!=null){
                    okHttpUtils= new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    public Call newsCall(Request request){
        return okHttpClient.newCall(request);
    }

}
