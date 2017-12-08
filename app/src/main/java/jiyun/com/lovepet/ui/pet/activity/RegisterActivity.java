package jiyun.com.lovepet.ui.pet.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;

public class RegisterActivity extends BaseActivity {


    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.rv_title)
    TextView rvTitle;
    @Bind(R.id.rv_subtitle)
    TextView rvSubtitle;
    @Bind(R.id.rv_registered)
    TextView rvRegistered;
    @Bind(R.id.et_bind_phone)
    EditText etBindPhone;
    @Bind(R.id.hqyzm)
    TextView hqyzm;
    @Bind(R.id.et_yanzhengma)
    EditText etYanzhengma;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_num_pass)
    EditText etNumPass;
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
        tvBack.setText("取消");
        tvBack.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        rvRegistered.setText("登录");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


}
