package jiyun.com.lovepet.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import jiyun.com.lovepet.R;

import jiyun.com.lovepet.ui.pet.activity.MapActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class HomeActivity extends BaseActivity  {
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<String> strings1 = new ArrayList<>();

    private NavigationView nav_view;
    private EditText editText;
    private ImageView imageView;
    private DrawerLayout draw;
    private ToggleButton shaixuan1;
    private ToggleButton shaixuan2;
    private View viewById1;
    private LinearLayout linearLayout;
    private ToggleButton shaixuan3;
    private PopupWindow popupWindow3;
    private ImageView imagetIntentToMap;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//加载布局
        initView();//寻找控件
        initData();//点击跳转到各个界面
        initLinnser();//用户点击listView事件

    }


    private void initLinnser() {

        shaixuan1.setOnClickListener(new View.OnClickListener() {

            private PopupWindow popupWindow;

            @Override
            public void onClick(View view) {
                if (shaixuan1.isChecked()){
                    View popupview = LayoutInflater.from(HomeActivity.this).inflate(R.layout.mypopupwindow1, null);
                    popupWindow = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setFocusable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());


                    popupWindow.showAsDropDown(linearLayout);
                }else {
                    popupWindow.dismiss();
                }
            }
        });
            shaixuan2.setOnClickListener(new View.OnClickListener() {

                private PopupWindow popupWindow2;

                @Override
                public void onClick(View view) {
                    if (shaixuan2.isChecked()){
                        View popupview = LayoutInflater.from(HomeActivity.this).inflate(R.layout.mypopupwindow2, null);
                        popupWindow2 = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                        //设置pop是否获取焦点
                        popupWindow2.setFocusable(true);
                        popupWindow2.setBackgroundDrawable(new BitmapDrawable());
//http://123.56.150.230:8885/dog_family/t_user_info

                        popupWindow2.showAsDropDown(linearLayout);
                    }else {
                         popupWindow2.dismiss();
                    }
                }
            });
        shaixuan3.setOnClickListener(new View.OnClickListener() {

            private TextView intentText;

            @Override
            public void onClick(View view) {
                if (shaixuan3.isChecked()){
                    View popupview = LayoutInflater.from(HomeActivity.this).inflate(R.layout.mypopupwindow3, null);
                    popupWindow3 = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow3.setFocusable(true);
                    popupWindow3.setBackgroundDrawable(new BitmapDrawable());


                    popupWindow3.showAsDropDown(linearLayout);
                    intentText = popupview.findViewById(R.id.intent);

                    intentText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(HomeActivity.this, "跳转到筛选界面", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    popupWindow3.dismiss();
                }
            }
        });

    }

    @Override
    protected void initView() {
        CustomTextLayout customTextLayout = (CustomTextLayout) findViewById(R.id.App_title);
        editText = (EditText) findViewById(R.id.editText);
        draw = (DrawerLayout) findViewById(R.id.draw);
        nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.inflateHeaderView(R.layout.header_layout);
        //侧滑用户换头像和昵称
        initChangedImage();
        //用户点击登录界面
        initLogin();

    }


    private void initChangedImage() {
        View headerView = nav_view.getHeaderView(0);
        RelativeLayout viewById = headerView.findViewById(R.id.intentUserchangeImage);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "点击事件!用户换取图片!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initLogin() {
        viewById1 = findViewById(R.id.queView);
        ImageView image = viewById1.findViewById(R.id.userXinXi);
        shaixuan1 = viewById1.findViewById(R.id.shaixuan1);
        shaixuan2 = viewById1.findViewById(R.id.shaixuan2);
        shaixuan3 = viewById1.findViewById(R.id.shaixuan3);
        linearLayout = viewById1.findViewById(R.id.ll_home);
        imagetIntentToMap = viewById1.findViewById(R.id.intentTo_Map);

        //跳转到用户登录界面
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "用户登录界面", Toast.LENGTH_SHORT).show();
            }
        });
        //跳转到地图界面
        imagetIntentToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(HomeActivity.this, MapActivity.class));
            }
        });







    }

    @Override
    protected void initData() {
        //跳转到各个页面!
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.messages:
                        Toast.makeText(HomeActivity.this, "消息", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pet:
                        Toast.makeText(HomeActivity.this, "宠物", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.order_details:
                        Toast.makeText(HomeActivity.this, "订单", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.collection_account:
                        Toast.makeText(HomeActivity.this, "钱包", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.about:
                        Toast.makeText(HomeActivity.this, "需知", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.perfect_information:
                        Toast.makeText(HomeActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }


}
