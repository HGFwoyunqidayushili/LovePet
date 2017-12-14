package jiyun.com.lovepet.api;

import android.app.Application;

import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.ScreenAdaptation;
import jiyun.com.lovepet.utils.SharePreferenceUtil;

/**
 * Created by 阿三 on 2017/12/7.
 */
public class App extends Application {
    public static BaseActivity baseActivity;
    private String SP_FILE_NAME="SP_FILE";
    public static App mApplication;
    private SharePreferenceUtil mSpUtil;


    public synchronized static App getInstance() {
        return mApplication;
    }
    public synchronized SharePreferenceUtil getmSpUtil(){
        if(mSpUtil==null){
            mSpUtil=new SharePreferenceUtil(this,SP_FILE_NAME);
        }
        return mSpUtil;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
        new ScreenAdaptation(this, 720,1280).register();

    }
}
