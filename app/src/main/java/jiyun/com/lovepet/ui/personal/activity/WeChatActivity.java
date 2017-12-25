package jiyun.com.lovepet.ui.personal.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;


public class WeChatActivity extends BaseActivity implements View.OnClickListener {


    private View wech;
    private TextView imgback;
    private TextView title;
    private TextView registered;
    private TextView subtitle;
    private Button button;
    private ImageView imgphoto;
    private TextView nickname;
    private CheckBox checkbox;

    @Override
    protected void initView() {
        wech = findViewById(R.id.wechat_toolbar);
        wech.setBackground(new ColorDrawable(Color.BLACK));
        imgback = (TextView) wech.findViewById(R.id.tv_back);
        title = (TextView) wech.findViewById(R.id.rv_title);
        registered = (TextView) wech.findViewById(R.id.rv_registered);
        subtitle = (TextView) wech.findViewById(R.id.rv_subtitle);
        button = (Button) findViewById(R.id.btn_confirm_login);
        imgphoto = (ImageView) findViewById(R.id.iv_photo);
        nickname = (TextView) findViewById(R.id.tv_nickname);
        checkbox = (CheckBox) findViewById(R.id.checkbox);


        button.setOnClickListener(this);
        subtitle.setVisibility(View.VISIBLE);
        subtitle.setTextSize(12);
        subtitle.setText("微信安全登录");
        imgback.setText("取消");
        //设置动态加载四周图片的
        imgback.setCompoundDrawables(null, null, null, null);
        imgback.setTextColor(Color.WHITE);
        imgback.setOnClickListener(this);
        title.setText("微信登录");
        registered.setText("重试");
        registered.setOnClickListener(this);
    }

    @Override
    public void initData(String s) {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_we_chat;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;

            case R.id.btn_confirm_login:
                Intent intent = new Intent(this,BingPhoneActivity.class);
                startActivity(intent);
                break;
        }
    }
}
