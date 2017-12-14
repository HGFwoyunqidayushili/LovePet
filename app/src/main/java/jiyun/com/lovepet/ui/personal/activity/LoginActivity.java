package jiyun.com.lovepet.ui.personal.activity;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.user.UserInfo;
import jiyun.com.lovepet.manager.UserManager;
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

public class LoginActivity extends BaseActivity implements View.OnClickListener{



    private EditText user_Phono;
    private EditText ussr_password;
    private Button login;
    //用户昵称
    private String User_Phono;
    private String User_Password;
    private UserManager userManager;
    //

    @Override
    protected void initView() {
        user_Phono= (EditText) findViewById(R.id.et_login_phone);
        ussr_password= (EditText) findViewById(R.id.et_login_pass);
        login= (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(this);
        userManager=UserManager.getIntance();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
             if(checkUserNameUserPhoo()){
               sendUserLogin();
             }
                break;
        }
    }
    //检查手机号和密码
        public boolean   checkUserNameUserPhoo(){
            User_Phono=user_Phono.getText().toString().trim();
            User_Password=ussr_password.getText().toString().trim();
            if(TextUtils.isEmpty(User_Phono)){
                showToast("手机号不能为空");
                return false;
            }
            if(TextUtils.isEmpty(User_Password)){
                showToast("密码不能为空");
                return false;
            }
            return true;
        }
    //发送登录请求
      public void sendUserLogin(){
          OkHttpClient okHttpClient=new OkHttpClient();
          Map<String,Object> map=new HashMap<>();
          map.put("userPhone",User_Phono);
          map.put("password", Md5Encrypt.md5(User_Password,"UTF-8"));
          String json= CJSON.toJSONMap(map);
          FormBody.Builder body = new FormBody.Builder();
          body.add(CJSON.DATA, json);
          Request request=new Request.Builder().url(CJSON.URL_STRING+"user/login.jhtml")
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
                                if(CJSON.getRET(str)){
                                    showToast("登陆成功");
                                    UserInfo userInfo=CJSON.parseObject(CJSON.getRESULT(str),UserInfo.class);
                                   userManager.saveUser(userInfo);
                                    Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                                     intent.putExtra("userInfo",userInfo);
                                    startActivity(intent);
                                    finish();

                                }
                              else {
                                 showToast(CJSON.getDESC(str));
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
