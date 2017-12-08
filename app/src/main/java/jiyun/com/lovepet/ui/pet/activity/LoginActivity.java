package jiyun.com.lovepet.ui.pet.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.tv_back)
    TextView ibBack;
    @Bind(R.id.rv_title)
    TextView rvTitle;
    @Bind(R.id.rv_registered)
    TextView rvRegistered;
    @Bind(R.id.et_login_phone)
    EditText etLoginPhone;
    @Bind(R.id.et_login_pass)
    EditText etLoginPass;
    @Bind(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_chart)
    TextView tvChart;
    @Bind(R.id.tv_qq)
    TextView tvQq;


    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.tv_chart, R.id.tv_qq, R.id.tv_back, R.id.rv_registered})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_chart:
                Intent intent = new Intent(this, WeChatActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_qq:
                break;
            case R.id.tv_back:
                finish();
                break;
            case R.id.rv_registered:
              
                break;
        }
    }
}
