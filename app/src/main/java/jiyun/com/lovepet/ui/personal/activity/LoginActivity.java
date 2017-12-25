package jiyun.com.lovepet.ui.personal.activity;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.user.UserInfo;
import jiyun.com.lovepet.manager.UserManager;
import jiyun.com.lovepet.qq.BaseUiListener;
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

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private EditText user_Phono;
    private EditText ussr_password;
    private Button login;
    //用户昵称
    private String User_Phono;
    private String User_Password;
    private UserManager userManager;
    private UserInfo userInfo;
    private Tencent mTencent;
    private IUiListener listener;
    private String Scope = "all";
    private TextView qq;
    private TextView forgetpwd;
    private TextView back;
    private TextView regist;
    //

    @Override
    protected void initView() {
        View title = findViewById(R.id.title);
        back = title.findViewById(R.id.tv_back);
        regist = title.findViewById(R.id.rv_registered);

        back.setOnClickListener(this);
        regist.setOnClickListener(this);

        user_Phono = (EditText) findViewById(R.id.et_login_phone);
        ussr_password = (EditText) findViewById(R.id.et_login_pass);
        forgetpwd = (TextView) findViewById(R.id.tv_forget_password);
        forgetpwd.setOnClickListener(this);
        qq = (TextView) findViewById(R.id.tv_qq);
        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(this);
        userManager = UserManager.getIntance();
        userInfo = new UserInfo();
        listener = new BaseUiListener();
        qq.setOnClickListener(this);
    }

    @Override
    public void initData(String s) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.rv_registered:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                if (checkUserNameUserPhoo()) {
                    sendUserLogin();
                }
                break;

            case R.id.tv_qq:
                login();

                break;
            case R.id.tv_forget_password:
                Intent intent1 = new Intent(LoginActivity.this, ForgotPwdActivity.class);
                startActivity(intent1);
                break;
        }
    }


    public void login() {
//                                   在腾讯开放平台获取的APPID
        mTencent = Tencent.createInstance("1106541335", this.getApplicationContext());
        if (!mTencent.isSessionValid()) {
            mTencent.login(this, Scope, listener);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode, resultCode, data, listener);


    }


    //检查手机号和密码
    public boolean checkUserNameUserPhoo() {
        User_Phono = user_Phono.getText().toString().trim();
        User_Password = ussr_password.getText().toString().trim();
        if (TextUtils.isEmpty(User_Phono)) {
            showToast("手机号不能为空");
            return false;
        }
        if (TextUtils.isEmpty(User_Password)) {
            showToast("密码不能为空");
            return false;
        }
        return true;
    }

    //发送登录请求
    public void sendUserLogin() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, Object> map = new HashMap<>();
        map.put("userPhone", User_Phono);
        map.put("password", Md5Encrypt.md5(User_Password, "UTF-8"));
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


                Log.e("TAG", str);

                JSONObject jsonObject = null;

                try {
                    jsonObject = new JSONObject(str);
                    final boolean ret = jsonObject.getBoolean("ret");
                    JSONObject jsonObject1 = jsonObject.getJSONObject("result");
                    final String userId = jsonObject1.getString("userId");
                    Log.e("TAG", "ID----------" + userId);
                    final long userPhone = jsonObject1.getLong("userPhone");
                    final String userName = jsonObject1.getString("userName");
                    App.baseActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (ret) {
                                showToast("登陆成功");
                                userInfo.setUserId(userId);
                                userInfo.setUserName(userName);
                                userInfo.setUserPhone(userPhone);
                                userManager.saveUser(userInfo);


                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                showToast("登录失败");
                            }
                        }
                    });
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

}
