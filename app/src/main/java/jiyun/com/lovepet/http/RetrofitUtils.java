package jiyun.com.lovepet.http;

import android.os.Environment;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * Created by lenovo on 2017/11/1.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;
    private final OkHttpClient okHttpClient;

    private RetrofitUtils() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/XiongMao");
        if (file != null) {
            file.mkdir();
        }
        Cache cache = new Cache(file, 1024 * 1024* 8);
        okHttpClient = new OkHttpClient.Builder().cache(cache).build();
        retrofit = new Retrofit.Builder().baseUrl("http://www.ipanda.com/")
                //Gson解析器
                .addConverterFactory(GsonConverterFactory.create())
                //添加缓存
                .client(okHttpClient)
                //添加RxJava转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }

        }
        return retrofitUtils;
    }

    public <T> T create(Class<T> service) {

        return retrofit.create(service);
    }

    ;
}
