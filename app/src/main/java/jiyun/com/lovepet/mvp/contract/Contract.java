package jiyun.com.lovepet.mvp.contract;

import android.content.Context;

import java.util.Map;

import jiyun.com.lovepet.http.Callback.HttpCallBack;

/**
 * Created by 阿三 on 2017/12/6.
 */
public interface Contract {
    interface Model  {
        void requestNewsData(Context context, String url, HttpCallBack httpCallBack);
        void requestNewsDatas(Context context, String url, Map<String, Object> map, HttpCallBack httpCallBack);
        void requsstNews(Context context ,String  url ,Map<String, Object> map, HttpCallBack httpCallBack );

    }

    interface Views<T>  extends HttpCallBack<T>{

    }

  interface Viewss<T> extends  HttpCallBack<T>{

  }


    interface Presenter {
        void getNewsData(String page);
        void getPostData(String url,Map<String,Object> map);

    }
}
