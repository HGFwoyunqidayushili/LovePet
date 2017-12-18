package jiyun.com.lovepet.qq;

import android.util.Log;

import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IRequestListener;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

/**
 * Created by DELL zhanghuirong on 2017/12/17.
 */

public class BaseApiListener implements IRequestListener {
    @Override
    public void onComplete(JSONObject jsonObject) {
//        showResult("IRequestListener.onComplete:", jsonObject.toString());
        Log.e("onComplete: ",jsonObject.toString() );
        doComplete(jsonObject);

    }

    private void doComplete(JSONObject jsonObject) {



    }

    @Override
    public void onIOException(IOException e) {
//        showResult("IRequestListener.onIOException:", e.getMessage());
        Log.e("onIOException: ", e.getMessage());
    }

    @Override
    public void onMalformedURLException(MalformedURLException e) {
//        showResult("IRequestListener.onMalformedURLException", e.toString());

        Log.e("onMalformedURLException", e.toString());
    }

    @Override
    public void onJSONException(JSONException e) {
//        Log.e("IRequestListener.onJSONException:", e.getMessage());
        Log.e("onJSONException: ", e.getMessage());
    }

    @Override
    public void onConnectTimeoutException(ConnectTimeoutException e) {
// TODO Auto-generated method stub
    }

    @Override
    public void onSocketTimeoutException(SocketTimeoutException e) {
// TODO Auto-generated method stub
    }

    //1.4版本中IRequestListener 新增两个异常
    @Override
    public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException e) {
// 当前网络不可用时触发此异常
    }

    @Override
    public void onHttpStatusException(HttpUtils.HttpStatusException e) {
// http请求返回码非200时触发此异常
    }

    @Override
    public void onUnknowException(Exception e) {
// 出现未知错误时会触发此异常
    }
}
