package jiyun.com.lovepet.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import jiyun.com.lovepet.R;

public class YuYueSuccess extends AppCompatActivity implements View.OnClickListener {


    private TextView foster_order_id;

    private TextView foster_order_time;
    private TextView foster_order_money;
    private Button foster_order_btn_ok;
    private LinearLayout activity_yu_yue_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_yue_success);
        initView();
    }

    private void initView() {

        foster_order_id = (TextView) findViewById(R.id.foster_order_id);

        foster_order_time = (TextView) findViewById(R.id.foster_order_time);

        foster_order_money = (TextView) findViewById(R.id.foster_order_money);
        foster_order_btn_ok = (Button) findViewById(R.id.foster_order_btn_ok);
        activity_yu_yue_success = (LinearLayout) findViewById(R.id.activity_yu_yue_success);

        foster_order_btn_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.foster_order_btn_ok:
                 finish();
                break;
        }
    }
}
