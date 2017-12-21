package jiyun.com.lovepet.qq;

import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.user.UserInfo;
import jiyun.com.lovepet.manager.UserManager;
import jiyun.com.lovepet.qq.bean.QQ;
import jiyun.com.lovepet.qq.bean.QQphoto;
import jiyun.com.lovepet.ui.HomeActivity;
import jiyun.com.lovepet.ui.personal.activity.BingPhoneActivity;
import jiyun.com.lovepet.utils.CJSON;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by DELL zhanghuirong on 2017/12/17.
 */

public class BaseUiListener implements IUiListener {
    //"https://graph.qq.com/user/get_user_info?access_token=access_token&oauth_consumer_key=1106541335&openid=openid&format=json"
    private String access_token1;
    private Object oauth_consumer_key;
    private String openid1;
    private String format;
    private UserInfo userInfo;
    private Tencent mTencent;

    @Override
    public void onComplete(Object o) {
//        mBaseMessageText.setText("onComplete:");
//        mMessageText.setText(o.toString());
        doComplete((JSONObject) o);
    }

    protected void doComplete(JSONObject values) {

//        values.toString();
        Log.e("doComplete: ", values.toString());

        Gson gson = new Gson();
        QQ qq = gson.fromJson(values.toString(), QQ.class);
        String access_token = qq.getAccess_token();


      /*  SharedPreferences sharedPreferences = App.baseActivity.getSharedPreferences("user_info", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("access_token", access_token);*/


        int authority_cost = qq.getAuthority_cost();
        int expires_in = qq.getExpires_in();
        int login_cost = qq.getLogin_cost();
        String msg = qq.getMsg();
        String openid = qq.getOpenid();

        //保存token和id
//        UserManager.getInstance().saveUser_info(access_token, openid);
//        edit.putString("openid", openid);
        userInfo = new UserInfo();
        userInfo.setUserId(openid);
        userInfo.setToken(access_token);


        UserManager.getIntance().saveUser(userInfo);


        String pay_token = qq.getPay_token();
        String pf = qq.getPf();
        String pfkey = qq.getPfkey();
        int query_authority_cost = qq.getQuery_authority_cost();
        int ret = qq.getRet();


        //获取用户QQ信息
        getQQ(access_token, openid);


    }


    public void getQQ(final String access_token, final String openid) {

        StringBuffer buffer = new StringBuffer("https://graph.qq.com/user/get_user_info");
        Map<String, Object> map = new HashMap<>();
        map.put("access_token", access_token);
        map.put("oauth_consumer_key", 1106541335);
        map.put("openid", openid);
        map.put("format", "json");

        buffer.append("?");

        for (int i = 0; i < map.size(); i++) {
            access_token1 = (String) map.get("access_token");
            oauth_consumer_key = map.get("oauth_consumer_key");
            openid1 = (String) map.get("openid");
            format = (String) map.get("format");
        }
        buffer.append("access_token").append("=").append(access_token1).append("&")
                .append("oauth_consumer_key").append("=").append(oauth_consumer_key).append("&")
                .append("openid").append("=").append(openid1).append("&")
                .append("format").append("=").append(format);


        final Request request = new Request.Builder()
                .url(buffer.toString())
                .build();

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure: ", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                if (response.code() == 200) {
                    Gson gson = new Gson();
                    QQphoto qQphoto = gson.fromJson(string, QQphoto.class);
                    //城市
                    String city = qQphoto.getCity();


                    Log.e("所在城市: ", city);

//                    大小为30×30像素的QQ空间头像URL。
                    String figureurl = qQphoto.getFigureurl();

                    Log.e("QQ空间头像: ", figureurl);

//                    大小为50×50像素的QQ空间头像URL。
                    String figureurl_1 = qQphoto.getFigureurl_1();
                    Log.e("QQ空间头像: ", figureurl_1);

//                    大小为100×100像素的QQ空间头像URL。
                    String figureurl_2 = qQphoto.getFigureurl_2();
                    Log.e("QQ空间头像: ", figureurl_2);

//                    大小为40×40像素的QQ头像URL。
                    String figureurl_qq_1 = qQphoto.getFigureurl_qq_1();
                    Log.e("QQ空间头像: ", figureurl_qq_1);

                    userInfo.setUserImage(figureurl_qq_1);


//                    大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有
                    String figureurl_qq_2 = qQphoto.getFigureurl_qq_2();

                    Log.e("QQ空间头像: ", figureurl_qq_2);

//                    性别。 如果获取不到则默认返回"男"
                    String gender = qQphoto.getGender();

                    Log.e("性别: ", gender);


                    int is_lost = qQphoto.getIs_lost();
//                    标识用户是否为黄钻用户（0：不是；1：是）。
                    String is_yellow_vip = qQphoto.getIs_yellow_vip();
//                    标识是否为年费黄钻用户（0：不是； 1：是）
                    String is_yellow_year_vip = qQphoto.getIs_yellow_year_vip();
                    String level = qQphoto.getLevel();
//                    用户在QQ空间的昵称。
                    String nickname = qQphoto.getNickname();

                    Log.e("昵称: ", nickname);

                    String province = qQphoto.getProvince();
//                    返回码
                    int ret = qQphoto.getRet();

                    Log.e("返回码: ", ret + "");

//                    如果ret<0，会有相应的错误信息提示，返回数据全部用UTF-8编码。
                    String msg = qQphoto.getMsg();
//                    标识用户是否为黄钻用户（0：不是；1：是）
                    String vip = qQphoto.getVip();
                    //出生在哪年
                    String year = qQphoto.getYear();
//                    黄钻等级
                    String yellow_vip_level = qQphoto.getYellow_vip_level();


                    //保存城市、头像、性别、昵称
//                    UserManager.getInstance().saveUserPhotos(city, figureurl_qq_1, gender, nickname);

                    //昵称
                    userInfo.setUserName(nickname);
                    //头像
                    userInfo.setUserImage(figureurl_qq_1);

                    Log.e("====: ",UserManager.getIntance().getUserInfo().getUserName() );


                    //跳转到绑定手机页面
                    Intent intent = new Intent(App.baseActivity, BingPhoneActivity.class);
                    App.baseActivity.startActivity(intent);



                    //发送登录请求
//                    sendlogin(openid);
                }
            }
        });

    }


    private void sendlogin(String openid) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, Object> map = new HashMap<>();
        map.put("threeId", openid);
        String json = CJSON.toJSONMap(map);
        FormBody.Builder body = new FormBody.Builder();
        body.add(CJSON.DATA, json);
        Request request = new Request.Builder().url(CJSON.URL_STRING + "user/login.jhtml")
                .post(body.build())
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String str = response.body().string();
                Log.e("onResponse: ", str);
                if (CJSON.getRET(str)) {
                    App.baseActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            App.baseActivity.showToast("登陆成功");
                        }
                    });
                    userInfo = CJSON.parseObject(CJSON.getRESULT(str), UserInfo.class);

                } else {
                    App.baseActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            App.baseActivity.showToast("登录失败");
                        }
                    });
                }
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UserManager.getIntance().saveUser(userInfo);
                        Intent intent = new Intent(App.baseActivity, HomeActivity.class);
                        intent.putExtra("userInfo", userInfo);
                        App.baseActivity.startActivity(intent);
                        App.baseActivity.finish();

                    }
                });
            }
        });
    }

    @Override
    public void onError(UiError e) {
//        showResult("onError:", "code:" + e.errorCode + ", msg:"
//                + e.errorMessage + ", detail:" + e.errorDetail);

        Log.e("onError:", "code:" + e.errorCode + ", msg:"
                + e.errorMessage + ", detail:" + e.errorDetail);
    }

    @Override
    public void onCancel() {
//        showResult("onCancel", "");
        Log.e("onCancel: ", "");
    }
}