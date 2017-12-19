package jiyun.com.lovepet.api;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class Wofo {

    public  void isWiFiActive(Context inContext, boolean iswifi) {
        WifiManager mWifiManager = (WifiManager) inContext
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        int ipAddress = wifiInfo == null ? 0 : wifiInfo.getIpAddress();
        if (mWifiManager.isWifiEnabled() && ipAddress != 0) {
            iswifi =true;
            Toast.makeText(inContext, "网络连接完好请放心上网", Toast.LENGTH_SHORT).show();
        } else {
            iswifi =false;
            Toast.makeText(inContext, "当前没有网络连接请注意流量使用", Toast.LENGTH_SHORT).show();
        }
    }

}
