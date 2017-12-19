package jiyun.com.lovepet.ui.pet.activity.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class Wofo {
public  static  boolean iswifi;
    public  static  boolean isWiFiActive(Context inContext) {
        WifiManager mWifiManager = (WifiManager) inContext
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        int ipAddress = wifiInfo == null ? 0 : wifiInfo.getIpAddress();
        if (mWifiManager.isWifiEnabled() && ipAddress != 0) {
            iswifi =true;
        } else {
            return iswifi=false;
        }
        return iswifi;
    }

}
