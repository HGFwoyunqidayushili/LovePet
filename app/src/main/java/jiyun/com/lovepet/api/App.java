package jiyun.com.lovepet.api;

import android.app.Application;

import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.ScreenAdaptation;

/**
 * Created by 阿三 on 2017/12/7.
 */
public class App extends Application {
    public static BaseActivity baseActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        new ScreenAdaptation(this, 720,1280).register();
    }
}
