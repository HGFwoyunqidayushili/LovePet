package jiyun.com.lovepet.ui.personal.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.qq.BaseUiListener;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CJSON;
import jiyun.com.lovepet.utils.CustomTextLayout;
import jiyun.com.lovepet.utils.Md5Encrypt;
import jiyun.com.lovepet.utils.MycountDownTimer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//import butterknife.Bind;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private CustomTextLayout App_title;
    private String URL_STRING = "http://123.56.150.230:8885/dog_family/";
    private EditText user_phono;
    private EditText user_name;
    private EditText user_password;
    private Button bt_register;
    private TextView tv_yanzhengma;
    private Tencent mTencent;
    private String Scope="all";
    private IUiListener listener;

    @Override
    protected void initView() {
        App_title = (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setLeftTv("取消", "#353535");
        App_title.setRightTv("登陆", "#353535");
        user_phono = (EditText) findViewById(R.id.user_phone);
        user_name = (EditText) findViewById(R.id.user_name);
        user_password = (EditText) findViewById(R.id.user_password);
        bt_register = (Button) findViewById(R.id.btn_register);
        bt_register.setOnClickListener(this);
        tv_yanzhengma = (TextView) findViewById(R.id.Tv_yanzhengma);
        tv_yanzhengma.setOnClickListener(this);
        initListener();

        TextView qq = (TextView) findViewById(R.id.tv_qqr);
        qq.setOnClickListener(this);
    }

    private void initListener() {
        App_title.setOnTextViewClickListener(new CustomTextLayout.OnTextViewClickListener() {

            @Override
            public void OnTextViewClick() {
                super.OnTextViewClick();
            }

            @Override
            public void OnRightTvClick() {
                super.OnRightTvClick();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void OnLeftTvClick() {
                super.OnLeftTvClick();

            }
        });
    }

    @Override
    public  void initData(String sd) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_register:
                sendPhonoRegister();
                break;
            case R.id.Tv_yanzhengma:
                if (!checkPhone()) {

                }
                MycountDownTimer mycountDownTimer = new MycountDownTimer(60000, 1000, tv_yanzhengma);
                mycountDownTimer.start();
                break;
            case R.id.tv_qqr:
//                login();
//                sendQQRegister();
                break;


        }
    }


    public void login() {

        listener = new BaseUiListener();

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


    //检查手机号
    protected boolean checkPhone() {
        String phoneString = user_phono.getText().toString().trim();
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
        String editpasswordsString = user_password.getText().toString();

        if (TextUtils.isEmpty(editpasswordsString)) {
            user_password.setText("密码不能为空");
            return false;
        } else if (editpasswordsString.length() < 6 || editpasswordsString.length() > 16) {
            user_password.setText("密码仅限6-16个字符");
            return false;
        } else {
            user_password.setText("");
            return true;
        }
    }

    //发送和手机号注册请求
    private void sendPhonoRegister() {
        if (!isConnected()) {
            showToast("请连接网络");
        }
        if (checkPhone()) {
            if (!checkPasswork()) {
                String user_phono1 = user_phono.getText().toString().trim();
                String user_name1 = user_name.getText().toString().trim();
                String user_password1 = user_password.getText().toString().trim();
                Map<String, Object> map = new HashMap<>();
                map.put("userPhone", user_phono1);
                map.put("userName", user_name1);
                map.put("password", Md5Encrypt.md5(user_password1, "UTF-8"));
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
                        App.baseActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    String str = response.body().string();
                                    if (CJSON.getRET(str)) {
                                        showToast("注册成功,请登录");

                                        RegisterActivity.this.finish();
                                    } else {
                                        showToast(CJSON.getDESC(json));
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        }
    }


    private void sendQQRegister() {
        if (!isConnected()) {
            showToast("请连接网络");
        }
        if (checkPhone()) {
            if (!checkPasswork()) {
                String user_phono1 = user_phono.getText().toString().trim();
                String user_name1 = user_name.getText().toString().trim();
                String user_password1 = user_password.getText().toString().trim();
                Map<String, Object> map = new HashMap<>();
                map.put("userPhone", user_phono1);
                map.put("userName", user_name1);
                map.put("password", Md5Encrypt.md5(user_password1, "UTF-8"));
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
                        App.baseActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    String str = response.body().string();
                                    if (CJSON.getRET(str)) {
                                        showToast("注册成功,请登录");

                                        RegisterActivity.this.finish();
                                    } else {
                                        showToast(CJSON.getDESC(json));
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        }
    }
}

