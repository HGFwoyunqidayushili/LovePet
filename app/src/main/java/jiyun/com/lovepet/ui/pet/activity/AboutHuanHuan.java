package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jiyun.com.lovepet.R;

public class AboutHuanHuan extends AppCompatActivity {

    private ImageView iv_backg;
    private ImageView iv_huan;
    private TextView tv_guans;
    private RelativeLayout rl_geng;
    private TextView tv_guan;
    private RelativeLayout rl_tiao;
    private LinearLayout activity_about_huan_huan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_huan_huan);
        initView();
        iv_backg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        iv_backg = (ImageView) findViewById(R.id.iv_backg);
        iv_huan = (ImageView) findViewById(R.id.iv_huan);
        tv_guans = (TextView) findViewById(R.id.tv_guans);
        rl_geng = (RelativeLayout) findViewById(R.id.rl_geng);
        tv_guan = (TextView) findViewById(R.id.tv_guan);
        rl_tiao = (RelativeLayout) findViewById(R.id.rl_tiao);
        activity_about_huan_huan = (LinearLayout) findViewById(R.id.activity_about_huan_huan);
        //检查更新
        rl_geng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(AboutHuanHuan.this).setTitle("友情提示")
                        .setMessage("已经是最新版本了!").setPositiveButton("Ok", null)
                        .show();
            }
        });
        rl_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutHuanHuan.this,
                        TiaokuanActivity.class);
                startActivity(intent);
            }
        });
    }
}
