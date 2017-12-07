package jiyun.com.lovepet.http.product;

import android.content.Context;

import java.lang.reflect.Type;

import jiyun.com.lovepet.http.Callback.HttpCallBack;

/**
 * Created by 阿三 on 2017/12/6.
 */
public abstract class RequestProduct<T> {
    public abstract void get(Context context, String page, Type type, HttpCallBack<T> httpCallBack);
    public abstract void post(Context context,String page, Type type , HttpCallBack<T> httpCallBack);
}
