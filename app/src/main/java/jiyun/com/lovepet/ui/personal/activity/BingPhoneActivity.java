package jiyun.com.lovepet.ui.personal.activity;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.user.UserInfo;
import jiyun.com.lovepet.manager.UserManager;
import jiyun.com.lovepet.qq.bean.ZhuCe;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.ui.HomeActivity;
import jiyun.com.lovepet.utils.CJSON;
import jiyun.com.lovepet.utils.Md5Encrypt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static jiyun.com.lovepet.utils.CJSON.URL_STRING;

public class BingPhoneActivity extends BaseActivity implements View.OnClickListener {


    private View bindphone;
    private TextView back;
    private TextView rv_title;
    private TextView rv_registered;
    private CircleImageView civ_phone;
    private EditText et_bind_phone;
    private TextView hqyzm;
    private EditText et_yanzhengma;
    private EditText et_name;
    private EditText et_pass;
    private EditText et_num_pass;
    private Button btn_et_sure;
    private TextView nicheng;
    private UserInfo userInfo;

    @Override
    protected void initView() {
        bindphone = findViewById(R.id.bindphone);
        back = (TextView) bindphone.findViewById(R.id.tv_back);
        rv_title = (TextView) bindphone.findViewById(R.id.rv_title);
        rv_registered = (TextView) bindphone.findViewById(R.id.rv_registered);
        back.setOnClickListener(this);
        //设置TextView图标用的
        Drawable drawable = getResources().getDrawable(R.drawable.back_gray);
        back.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        rv_title.setVisibility(View.VISIBLE);
        rv_title.setText("绑定手机");
        rv_title.setTextColor(Color.BLACK);
        bindphone.setBackground(new ColorDrawable(Color.WHITE));
        rv_registered.setVisibility(View.GONE);


        civ_phone = (CircleImageView) findViewById(R.id.civ_phone);
        nicheng = (TextView) findViewById(R.id.tv_title);
        et_bind_phone = (EditText) findViewById(R.id.et_bind_phone);
        hqyzm = (TextView) findViewById(R.id.hqyzm);
        et_bind_phone = (EditText) findViewById(R.id.et_bind_phone);
        et_yanzhengma = (EditText) findViewById(R.id.et_yanzhengma);
        et_name = (EditText) findViewById(R.id.et_name);
//        et_pass = (EditText) findViewById(R.id.et_pass);
        et_num_pass = (EditText) findViewById(R.id.et_num_pass);
        btn_et_sure = (Button) findViewById(R.id.btn_et_sure);

//      头像
        Glide.with(BingPhoneActivity.this).load(UserManager.getIntance().getUserInfo().getUserImage()).into(civ_phone);
        //昵称
        nicheng.setText(UserManager.getIntance().getUserInfo().getUserName());
        //确定按钮的点击事件
        btn_et_sure.setOnClickListener(this);
    }

    @Override
    public void initData(String str) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bing_phone;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.btn_et_sure:

                //QQ注册
                sendPhonoRegister();
                break;

        }
    }


    //检查手机号
    protected boolean checkPhone() {
        String phoneString = et_bind_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phoneString)) {
            showToast("手机号不能为空");
            return false;
        }
        Pattern pattern = Pattern.compile("^1[3578]\\d{9}$");
        Matcher matcher = pattern.matcher(phoneString);
        if (matcher.matches()) {
            return true;
        } else {
            showToast("手机格式不正确");
            return false;
        }
    }

    /**
     * 检查密码
     *
     * @return
     */
    private boolean checkPasswork() {
        String editpasswordsString = et_num_pass.getText().toString();

        if (TextUtils.isEmpty(editpasswordsString)) {
            et_num_pass.setText("密码不能为空");
            return false;
        } else if (editpasswordsString.length() < 6 || editpasswordsString.length() > 16) {
            et_num_pass.setText("密码仅限6-16个字符");
            return false;
        } else {
            et_num_pass.setText("");
            return true;
        }
    }


    //发送和手机号注册请求
    private void sendPhonoRegister() {
        if (!App.baseActivity.isConnected()) {
            App.baseActivity.showToast("请连接网络");
        }
        if (checkPhone()) {
            if (!checkPasswork()) {
                String name = et_name.getText().toString().trim();
                String phone = et_bind_phone.getText().toString().trim();
                String yanzhengma = et_yanzhengma.getText().toString().trim();
                String password = et_num_pass.getText().toString().trim();
                Map<String, Object> map = new HashMap<>();
                map.put("userPhone", phone);
                //qq昵称
                String userName = UserManager.getIntance().getUserName();
                //QQ头像
                String usetPhotos = UserManager.getIntance().getUsetPhotos();
//                qqID
                String userId = UserManager.getIntance().getUserId();

                map.put("userName", name);
                map.put("password", Md5Encrypt.md5(password, "UTF-8"));
                map.put("userImage", usetPhotos);
                map.put("threeId", userId);
                OkHttpClient okHttpClient = new OkHttpClient();
                final String json = CJSON.toJSONMap(map);

                FormBody.Builder body = new FormBody.Builder();
                body.add(CJSON.DATA, json);
                Request request = new Request.Builder()
                        .url(URL_STRING + "user/register.jhtml")
                        .post(body.build())
                        .build();

                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        String string = response.body().string();
                        Gson gson = new Gson();
                        ZhuCe zhuCe = gson.fromJson(string, ZhuCe.class);
                        ZhuCe.ResultBean result = zhuCe.getResult();
                        String threeId = result.getThreeId();
                        //电话号
                        long userPhone = result.getUserPhone();


//                        qq登录
                        sendlogin(threeId,userPhone);

                    }
                });
            }
        }
    }


    private void sendlogin(String openid, final Long userPhone) {
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

                    userInfo.setUserPhone(userPhone);



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
                        startActivity(intent);
                        finish();

                    }
                });
            }
        });
    }
}
