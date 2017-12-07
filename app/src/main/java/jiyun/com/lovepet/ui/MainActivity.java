package jiyun.com.lovepet.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class MainActivity extends BaseActivity {

    private NavigationView nav_view;
    private EditText editText;
    private ImageView imageView;
    private DrawerLayout draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//加载布局
        initView();//寻找控件
        initData();//点击跳转到各个界面
        //分支
    }
    @Override
    protected void initView() {
        CustomTextLayout customTextLayout = (CustomTextLayout) findViewById(R.id.App_title);
        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
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
                Toast.makeText(MainActivity.this, "点击事件!用户换取图片!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initLogin() {
        View viewById1 = findViewById(R.id.queView);
        ImageView image = viewById1.findViewById(R.id.userXinXi);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "用户登录界面", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
       nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(MenuItem item) {
               switch (item.getItemId()){
                   case R.id.messages:
                       Toast.makeText(MainActivity.this, "消息", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.pet:
                       Toast.makeText(MainActivity.this, "宠物", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.order_details:
                       Toast.makeText(MainActivity.this, "订单", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.collection_account:
                       Toast.makeText(MainActivity.this, "钱包", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.about:
                       Toast.makeText(MainActivity.this, "需知", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.perfect_information:
                       Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                       break;

               }
               return false;
           }
       });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
