package jiyun.com.lovepet.ui.pet.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.New_function_Activity;
import jiyun.com.lovepet.ui.huancun.GlideCacheUtil;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout suggest;
    private RelativeLayout New_function;
    private ToggleButton wifiPhoto;
    private RelativeLayout aboutHuianHuan;
    private TextView huancunSize;
    private RelativeLayout clear_HuanCun;
    private String cacheSize;
   private int a;
    private int c=0;
    private int d=1;
    private SharedPreferences.Editor editor;
    private int f=0;
    private int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);


        initView();
        initData();


    }

    private void initData() {
//        if (a==f){
//            wifiPhoto.setChecked(true);
//        }else  if (x==a){
//            wifiPhoto.setChecked(false);
//        }
    }

    private void initView() {
        suggest = (RelativeLayout) findViewById(R.id.suggest);
        suggest.setOnClickListener(this);
        //跳转产品建议
        suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this, PsActivity.class);
                startActivity(intent);
            }
        });
       //新功能介绍
        New_function = (RelativeLayout) findViewById(R.id.New_function);
        New_function.setOnClickListener(this);
        New_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SetActivity.this, New_function_Activity.class));
            }
        });
        //wifi显示图片
//                wifiPhoto = (ToggleButton) findViewById(R.id.wifiPhoto);
//        wifiPhoto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    a=0;
//                    f = 3;
//                } else {
//                    a=1;
//                    x = 1;
//                    f=3;
//                }
//            }
//        });

        //关于欢欢
        aboutHuianHuan = (RelativeLayout) findViewById(R.id.aboutHuianHuan);
        aboutHuianHuan.setOnClickListener(this);
        aboutHuianHuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(SetActivity.this,AboutHuanHuan.class));

            }
        });
        //获取缓存清除缓存
        huancunSize = (TextView) findViewById(R.id.huancunSize);
        huancunSize.setOnClickListener(this);
        clear_HuanCun = (RelativeLayout) findViewById(R.id.rl_clear);
        clear_HuanCun.setOnClickListener(this);
        cacheSize = GlideCacheUtil.getInstance().getCacheSize(SetActivity.this);
        huancunSize.setText(cacheSize);
        clear_HuanCun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SetActivity.this)
                        .setTitle("系统提示")
                        .setMessage("确定要清除吗?")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        GlideCacheUtil.getInstance().clearImageAllCache(SetActivity.this);
                                        String cacheSize1 = GlideCacheUtil.getInstance().getCacheSize(SetActivity.this);
                                        huancunSize.setText(cacheSize1);
                                        Toast.makeText(SetActivity.this, "清除成功", Toast.LENGTH_SHORT).show();

                                    }
                                });

                            }
                        })
                        .setNegativeButton("再想想",
                                new DialogInterface.OnClickListener() {// 添加返回按钮
                                    public void onClick(DialogInterface dialog,
                                                        int which) {// 响应事件
                                        dialog.dismiss();
                                    }
                                }).show();

            }
        });


    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(SetActivity.this,PsActivity.class);
//        startActivity(intent);
    }
}
