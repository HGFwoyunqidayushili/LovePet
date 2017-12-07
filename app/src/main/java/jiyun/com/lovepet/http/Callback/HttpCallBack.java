package jiyun.com.lovepet.http.Callback;

/**
 * Created by 阿三 on 2017/12/6.
 */
public interface HttpCallBack<T> {
    void success(T t);

    void failure(Throwable e);
}
