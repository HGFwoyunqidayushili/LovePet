package jiyun.com.lovepet.mvp.contract;

import android.content.Context;

import jiyun.com.lovepet.http.Callback.HttpCallBack;

/**
 * Created by 阿三 on 2017/12/6.
 */
public interface Contract {
    interface Model  {
        void requestNewsData(Context context, String url, HttpCallBack httpCallBack);
    }

    interface Views<T>  extends HttpCallBack<T>{

    }

    interface Presenter {
        void getNewsData(String page);
    }
}
