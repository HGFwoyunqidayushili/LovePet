package jiyun.com.lovepet.ui;

import android.content.Intent;
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
import jiyun.com.lovepet.ui.personal.activity.PersinalInfoActivity;
import jiyun.com.lovepet.ui.pet.activity.MyPetActivity;
import jiyun.com.lovepet.ui.wallet.activity.MyWalletActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class HomeActivity extends BaseActivity  {

    private NavigationView nav_view;
    private EditText editText;
    private ImageView imageView;
    private DrawerLayout draw;
    private String URL_String="http://123.56.150.230:8885/dog_family/user/updateUserInfo.jhtml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//加载布局
        initView();//寻找控件
        initData();//点击跳转到各个界面
        //分支
        //继续上传
        //再次急=进行上传
        //fffffffffffff
        //33333333333
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
                Intent intent=new Intent(HomeActivity.this, PersinalInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initLogin() {
        View viewById1 = findViewById(R.id.queView);
        ImageView image = viewById1.findViewById(R.id.userXinXi);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void initData() {


        //跳转到各个页面!
       nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           public Intent intent;

           @Override
           public boolean onNavigationItemSelected(MenuItem item) {
               switch (item.getItemId()){
                   case R.id.messages:
                       Toast.makeText(HomeActivity.this, "消息", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.pet:
                       intent=new Intent(HomeActivity.this, MyPetActivity.class);
                       startActivity(intent);
                       Toast.makeText(HomeActivity.this, "宠物", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.order_details:
                       break;
                   case R.id.collection_account:
                       intent=new Intent(HomeActivity.this, MyWalletActivity.class);
                       startActivity(intent);

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
