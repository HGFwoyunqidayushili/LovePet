package jiyun.com.lovepet.http.factory;

import jiyun.com.lovepet.http.product.RequestProduct;

/**
 * Created by 阿三 on 2017/12/6.
 */
public class RequestFactoryProduct extends RequestFactory {
    @Override
    public <T extends RequestProduct> RequestProduct create(Class<T> tClass) {
        try {
            RequestProduct requestProduct= (RequestProduct) Class.forName(tClass.getName()).newInstance();
            return requestProduct;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
