package jiyun.com.lovepet.mvp.Model;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.http.Callback.HttpCallBack;
import jiyun.com.lovepet.http.product.RequestProduct;
import jiyun.com.lovepet.utils.CJSON;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 阿三 on 2017/12/6.
 */
public class OkhttpProduct<T> extends RequestProduct<T> {
    private HttpCallBack<T> httpCallBack;
    private static final int SUCCESS=1;
    private static final int FAILURE=2;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SUCCESS:



                    break;
                case FAILURE:

                    break;
            }
        }
    };
    @Override
    public void get(Context context, String page, final Type type, HttpCallBack <T> httpCallBack) {
        this.httpCallBack=httpCallBack;
        Request request=new Request.Builder().url(page).build();
        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
         call.enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String str=response.body().string();
                 Log.e("TAG",str);
                 Log.e("TAG",str);
                 Gson gson=new Gson();
                 T o=gson.fromJson(str,type);

                 Message message=handler.obtainMessage(SUCCESS);
                 message.obj=o;
                 handler.sendMessage(message);
             }
         });
    }

    @Override
    public void post(Context context, String page, Map<String, Object> map, final Type type, final HttpCallBack<T> httpCallBack) {
        FormBody.Builder builder= new FormBody.Builder();

            for(String key:map.keySet()){
                builder.add(key, String.valueOf(map.get(key)));
            }
        String json= CJSON.toJSONMap(map);
        builder.add(CJSON.DATA,json);

        Request request=new Request.Builder().url(page).post(builder.build()).build();
        OkHttpClient okHttpClient=new OkHttpClient();
          okHttpClient.newCall(request).enqueue(new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {

              }

              @Override
              public void onResponse(Call call, Response response) throws IOException {
                  String str=response.body().string();
                  Log.e("TAG",str);
                  Gson gson=new Gson();
                  final T o=gson.fromJson(str,type);
                  App.baseActivity.runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                        httpCallBack.success(o);
                      }
                  });

              }
          });
    }

    @Override
    public void post1(Context context, String page, Map<String, Object> map, final Type type, final HttpCallBack<T> httpCallBack) {
        FormBody.Builder builder= new FormBody.Builder();

        for(String key:map.keySet()){
            builder.add(key, String.valueOf(map.get(key)));
        }
        String json= CJSON.toJSONMap(map);
        builder.add(CJSON.DATA,json);

        Request request=new Request.Builder().url(page).post(builder.build()).build();
        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.body().string();
                Log.e("TAG",str);
                Gson gson=new Gson();
                final T o=gson.fromJson(str,type);
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.success1(o);
                    }
                });

            }
        });
    }

    @Override
    public void post(Context context, String page, Type type, HttpCallBack httpCallBack) {

    }
}
