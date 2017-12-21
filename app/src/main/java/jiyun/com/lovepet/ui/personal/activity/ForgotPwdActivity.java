package jiyun.com.lovepet.ui.personal.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.ToastUtil;

public class ForgotPwdActivity extends BaseActivity {


    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.rv_title)
    TextView rvTitle;
    @Bind(R.id.rv_subtitle)
    TextView rvSubtitle;
    @Bind(R.id.rv_registered)
    TextView rvRegistered;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_yzm)
    EditText etYzm;
    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.et_mm)
    EditText etMm;
    @Bind(R.id.et_qrmm)
    EditText etQrmm;

    @Override
    protected void initView() {
        rvTitle.setText("忘记密码");
        rvTitle.setTextSize(18);
        rvTitle.setTextColor(Color.BLACK);
        rvRegistered.setText("提交");
        rvRegistered.setTextSize(14);
        rvRegistered.setTextColor(Color.BLACK);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgot_pwd;
    }


    @OnClick({R.id.tv_back, R.id.rv_registered, R.id.textView3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.rv_registered:
                //账号
                String phone = etPhone.getText().toString().trim();
                //验证码
                String yzm = etYzm.getText().toString().trim();
                //密码
                String etmm = etMm.getText().toString().trim();
                //却认密码
                String qrmm = etQrmm.getText().toString().trim();

                if (phone.isEmpty()) {
                    ToastUtil.show("手机号码不能为空");
                    break;
                }
                if (!phone
                        .matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$")) {
                    ToastUtil.show("手机号码不合法");
                }
                break;
            case R.id.textView3:

                break;
        }
    }
}
