package jiyun.com.lovepet.mvp.Model;

import android.content.Context;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import jiyun.com.lovepet.http.Callback.HttpCallBack;
import jiyun.com.lovepet.http.factory.RequestFactory;
import jiyun.com.lovepet.http.factory.RequestFactoryProduct;
import jiyun.com.lovepet.http.product.RequestProduct;
import jiyun.com.lovepet.mvp.contract.Contract;

/**
 * Created by 阿三 on 2017/12/6.
 */
public class InfoModel implements Contract.Model{
    @Override
    public void requestNewsData(Context context, String url, HttpCallBack httpCallBack) {
        RequestFactory requestFactory=new RequestFactoryProduct();
        RequestProduct requestProduct = requestFactory.create(OkhttpProduct.class);
        Type[] genericInterfaces = httpCallBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = null;
        for(int i = 0; i < genericInterfaces.length; i++){
            if(genericInterfaces[i] instanceof ParameterizedType){
                actualTypeArguments=((ParameterizedType) genericInterfaces[i]).getActualTypeArguments();
            }
        }
        Type type = actualTypeArguments[0];
        requestProduct.get(context,url, type, httpCallBack);
    }

    @Override
    public void requestNewsDatas(Context context, String url, Map<String, Object> map, HttpCallBack httpCallBack) {
        RequestFactory requestFactory=new RequestFactoryProduct();
        RequestProduct requestProduct = requestFactory.create(OkhttpProduct.class);

        Type[] genericInterfaces = httpCallBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = null;
        for(int i = 0; i < genericInterfaces.length; i++){
            if(genericInterfaces[i] instanceof ParameterizedType){
                actualTypeArguments=((ParameterizedType) genericInterfaces[i]).getActualTypeArguments();
            }
        }
        Type type = actualTypeArguments[0];
        requestProduct.post(context,url,map,type, httpCallBack);
    }

    @Override
    public void requsstNews(Context context, String  url, Map<String, Object> map, HttpCallBack httpCallBack) {
        RequestFactory requestFactory=new RequestFactoryProduct();
        RequestProduct requestProduct = requestFactory.create(OkhttpProduct.class);

        Type[] genericInterfaces = httpCallBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = null;
        for(int i = 0; i < genericInterfaces.length; i++){
            if(genericInterfaces[i] instanceof ParameterizedType){
                actualTypeArguments=((ParameterizedType) genericInterfaces[i]).getActualTypeArguments();
            }
        }
        Type type = actualTypeArguments[0];
        requestProduct.post(context,url,map,type, httpCallBack);
    }


}
