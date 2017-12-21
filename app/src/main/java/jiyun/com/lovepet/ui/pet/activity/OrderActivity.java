package jiyun.com.lovepet.ui.pet.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import java.util.Calendar;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.YuYueSuccess;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener,TimePicker.OnTimeChangedListener {

    private Calendar timeinstance;
    private int year;
    private int month;
    private int day_month;
    private int hour_day;
    private TextView queding_yuyue;
    private TextView qian_yuyue;
    private TextView jia1_yuyue;
    private TextView jian1_yuyue;
    private EditText tian1_yuyue;
    int a = 1;
    int b = 1;
    private Handler handler;
    private Runnable runnable;
    int xizao = 60;
    private TextView jian2_yuyue;
    private TextView jia2_yuyue;
    private EditText tian2_yuyue;
    private TextView qian1_yuyue;
    private TextView qian2_yuyue;
    private TextView heji_yuyue;
    private TextView intentjiyang;
    private TextView jiyangshijian_jiyang;
    private TextView intentjiehui;
    private TextView jiehuishijian_jiyang;
    private DatePicker timepick;
    private DatePicker timepicks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        initCandler();
        initViews_DatePicker();
        handler = new Handler();

    }
    // 对话框形式的datePicker
    private DatePickerDialog getDatePicker_Dialog() {
        DatePickerDialog dpd = new DatePickerDialog(OrderActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        jiyangshijian_jiyang.setText(year + "年 "
                                + (monthOfYear + 1) + "月 " + dayOfMonth + "日");
                    }
                }, year, month - 1, day_month);
        return dpd;
    }
    // 对话框形式的datePicker
    private DatePickerDialog getDatePicker_Dialogs() {
        DatePickerDialog dpd = new DatePickerDialog(OrderActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        jiehuishijian_jiyang.setText(year + "年 "
                                + (monthOfYear + 1) + "月 " + dayOfMonth + "日");
                    }
                }, year, month - 1, day_month);
        return dpd;
    }

    // 初始化控件--DatePicker比较特殊，init中的参数添加监听事件
    private void initViews_DatePicker() {
        // 初始化datePicker(注意第二个参数传入的是没有进行+1操作的Month值)
        timepick.init(year, timeinstance.get(Calendar.MONTH), day_month,
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        jiyangshijian_jiyang.setText(year + "年 "
                                + (monthOfYear + 1) + "月 " + dayOfMonth + "日");
                    }
                });
        timepicks.init(year, timeinstance.get(Calendar.MONTH), day_month,
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        jiehuishijian_jiyang.setText(year + "年 "
                                + (monthOfYear + 1) + "月 " + dayOfMonth + "日");
                    }
                });

    }

    private void initCandler() {
        //通过日历类获取当前时间
        timeinstance = Calendar.getInstance();
        //获取年
        year = timeinstance.get(Calendar.YEAR);
        //获取月(这里获取的月份比现实中少一个月)
        month = timeinstance.get(Calendar.MONTH) + 1;
        //获取月里面的具体那一天
        day_month = timeinstance.get(Calendar.DAY_OF_MONTH);
    }


    private void initView() {
        queding_yuyue = (TextView) findViewById(R.id.queding_yuyue);
        queding_yuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderActivity.this, YuYueSuccess.class));
            }
        });
        qian_yuyue = (TextView) findViewById(R.id.qian_yuyue);
        jia1_yuyue = (TextView) findViewById(R.id.jia1_yuyue);

        jia1_yuyue.setOnClickListener(this);
        jian1_yuyue = (TextView) findViewById(R.id.jian1_yuyue);
        jian1_yuyue.setOnClickListener(this);
        tian1_yuyue = (EditText) findViewById(R.id.tian1_yuyue);
        tian1_yuyue.setOnClickListener(this);


        jian2_yuyue = (TextView) findViewById(R.id.jian2_yuyue);
        jian2_yuyue.setOnClickListener(this);
        jia2_yuyue = (TextView) findViewById(R.id.jia2_yuyue);
        jia2_yuyue.setOnClickListener(this);
        tian2_yuyue = (EditText) findViewById(R.id.tian2_yuyue);
        tian2_yuyue.setOnClickListener(this);
        qian1_yuyue = (TextView) findViewById(R.id.qian1_yuyue);
        qian1_yuyue.setOnClickListener(this);
        qian2_yuyue = (TextView) findViewById(R.id.qian2_yuyue);
        qian2_yuyue.setOnClickListener(this);
        heji_yuyue = (TextView) findViewById(R.id.heji_yuyue);
        heji_yuyue.setOnClickListener(this);
        intentjiyang = (TextView) findViewById(R.id.intentjiyang);
        intentjiyang.setOnClickListener(this);
        jiyangshijian_jiyang = (TextView) findViewById(R.id.jiyangshijian_jiyang);
        jiyangshijian_jiyang.setOnClickListener(this);
        intentjiehui = (TextView) findViewById(R.id.intentjiehui);
        intentjiehui.setOnClickListener(this);
        jiehuishijian_jiyang = (TextView) findViewById(R.id.jiehuishijian_jiyang);
        jiehuishijian_jiyang.setOnClickListener(this);
        timepick = (DatePicker) findViewById(R.id.timepick);
        timepick.setOnClickListener(this);
        timepicks = (DatePicker) findViewById(R.id.timepicks);
        timepicks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.jia1_yuyue:
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        a++;
                        tian1_yuyue.setText(a + "");
                        qian1_yuyue.setText(a * 60 + "");
                    }
                };
                handler.postDelayed(runnable, 0);
                break;
            case R.id.jian1_yuyue:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (a > 1) {
                            a--;
                            tian1_yuyue.setText(a + "");
                            qian1_yuyue.setText(a * 60 + "");
                        }


                        if (a == 0) {
                            Toast.makeText(OrderActivity.this, "最小不能小于0!", Toast.LENGTH_SHORT).show();
                            tian1_yuyue.setText("错误!不能小于0!");
                        }
                    }
                };
                handler.postDelayed(runnable, 0);
                break;
            case R.id.jia2_yuyue:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        b++;
                        tian2_yuyue.setText(b + "");
                        qian2_yuyue.setText(b * 50 + "");
                        if (b == 0) {
                            Toast.makeText(OrderActivity.this, "最小不能小于0!", Toast.LENGTH_SHORT).show();
                            tian1_yuyue.setText("错误!不能小于0!");
                        }
                    }
                };
                handler.postDelayed(runnable, 0);
                break;
            case R.id.jian2_yuyue:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        b--;
                        tian2_yuyue.setText(b + "");
                        qian2_yuyue.setText(b * 50 + "");
                        if (b == 0) {
                            Toast.makeText(OrderActivity.this, "最小不能小于0!", Toast.LENGTH_SHORT).show();
                            tian1_yuyue.setText("错误!不能小于0!");
                        }
                    }
                };
                handler.postDelayed(runnable, 0);
                break;
            case R.id.intentjiyang:
                getDatePicker_Dialog().show();
                break;
            case R.id.intentjiehui:
                getDatePicker_Dialogs().show();
                break;
            case R.id.jiyangshijian_jiyang:
                break;
            case R.id.jiehuishijian_jiyang:
                break;
        }
        String qian1 = qian1_yuyue.getText().toString().trim();
        String qian2 = qian2_yuyue.getText().toString().trim();
        Integer intent = Integer.parseInt(qian1);
        Integer intent2 = Integer.parseInt(qian2);
        int i = intent + intent2;
        String s = String.valueOf(i);
        heji_yuyue.setText(s + "元");
    }


    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

    }
}