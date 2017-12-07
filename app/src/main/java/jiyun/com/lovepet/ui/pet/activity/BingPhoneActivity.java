package jiyun.com.lovepet.ui.pet.activity;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;

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
//hh
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
        et_bind_phone = (EditText) findViewById(R.id.et_bind_phone);
        hqyzm = (TextView) findViewById(R.id.hqyzm);
        et_bind_phone = (EditText) findViewById(R.id.et_bind_phone);
        et_yanzhengma = (EditText) findViewById(R.id.et_yanzhengma);
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_num_pass = (EditText) findViewById(R.id.et_num_pass);
        btn_et_sure = (Button) findViewById(R.id.btn_et_sure);

    }

    @Override
    protected void initData() {

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

        }
    }
}
