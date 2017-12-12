/**
 * @描述		:	
 * @作�??	    :Android - csx
 * @创建日期  :2016�?3�?14�? 下午3:01:54  
 *
 */
package jiyun.com.lovepet.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * @描述 :网络判断工具
 * @作�?? :Android - csx
 * @创建日期 :2016�?3�?14�? 下午3:01:54
 *
 */
public class ConnectionUtils {

	// 获取网络管理信息
	private static ConnectivityManager manager = null;

	// 获取网络信息
	private static NetworkInfo network = null;

	public static final String IP = "ip";

	/**
	 * 
	 * @描述 :是否连接网络
	 * @方法名称 :isConnNetWork----&gt;ConnectionUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?14�? 下午3:03:02
	 * @return
	 *
	 */
	@SuppressWarnings("static-access")
	public static boolean isConnNetWork(Context context) {
		manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
		network = manager.getActiveNetworkInfo();
		if (network != null && network.isAvailable() && network.isConnectedOrConnecting()) {
			// 有网
			return true;
		} else {
			// 没网
			return false;
		}
	}

	/**
	 * 
	 * @描述 :判断当前网络是否为WiFi
	 * @方法名称 :isWiFi----&gt;ConnectionUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?14�? 下午3:21:46
	 * @return
	 *
	 */
	@SuppressWarnings("static-access")
	public static boolean isWiFi(Context context) {
		manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
		network = manager.getActiveNetworkInfo();
		if (network != null && network.isAvailable()) {
			// 是网
			if (network.getType() == ConnectivityManager.TYPE_WIFI) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * @描述 :获取ip
	 * @方法名称 :getIp----&gt;ConnectionUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?24�? 上午9:11:24
	 * @param context
	 * @return
	 *
	 */
	public static String getIp(Context context) {
		// 获取WiFi管理�?
		WifiManager wifiManager = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
		// 判断wifi是否�?�?
		if (!wifiManager.isWifiEnabled()) {
			return "127.0.0.3";
		}
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();

		int ipAddress = wifiInfo.getIpAddress();
		String ip = intToIp(ipAddress);

		return ip;

	}

	/**
	 * 
	 * @描述 :转化ip
	 * @方法名称 :intToIp----&gt;ConnectionUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?24�? 上午9:11:02
	 * @param i
	 * @return
	 *
	 */
	private static String intToIp(int i) {

		return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + (i >> 24 & 0xFF);
	}

	// public static boolean getConnState() {
	// return new
	// ConnServers().execute(AppUtils.BASE_URL_OUT).equals("success");
	// }
	//
	// /**
	// *
	// * @描述 : 判断和服务器是否连接
	// * @类名 : ConnServer
	// * @作�?? : Android - yhq
	// * @版本 : v1.0
	// * @日期 : 2016�?3�?31�?
	// *
	// */
	// static class ConnServers extends AsyncTask<String, String, String> {
	//
	// /**
	// *
	// * 判断服务器是否开�?
	// *
	// * @param path
	// * 网络服务器地�?
	// * @return 服务器开�? 服务器未�?�?
	// */
	//
	// @Override
	// protected String doInBackground(String... params) {
	// try {
	// HttpURLConnection conn = (HttpURLConnection) new
	// URL(params[0]).openConnection();
	// conn.setConnectTimeout(10000);// 设置网络连接超时的时间为10�?
	// conn.setRequestMethod("GET"); // 设置请求方法为GET
	// conn.setDoInput(true); // 打开输入�?
	// conn.setRequestProperty("User-Agent",
	// "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101
	// Firefox/43.0");
	// conn.setRequestProperty("Accept",
	// "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	// conn.setRequestProperty("Accept-Language",
	// "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
	// conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
	// conn.setRequestProperty("Connection", "keep-alive");
	// conn.setRequestProperty("Cache-Control", "max-age=0");
	// conn.setRequestProperty("DNT", "1");
	// if (conn.getResponseCode() == 200) {
	// return "success";
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "ServerError";
	// }
	// return "success";
	// }
	// }
}
