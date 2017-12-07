package jiyun.com.lovepet.http.factory;

import jiyun.com.lovepet.http.product.RequestProduct;

/**
 * Created by 阿三 on 2017/12/6.
 */
public abstract class RequestFactory {
    public abstract <T extends RequestProduct> RequestProduct create(Class<T> tClass);
}
