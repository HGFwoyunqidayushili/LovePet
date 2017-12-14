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

                if (draw.isDrawerOpen(Gravity.LEFT)) {
                    draw.closeDrawer(Gravity.LEFT);
                } else {
                    draw.openDrawer(Gravity.LEFT);
                }
                Toast.makeText(HomeActivity.this, "打开", Toast.LENGTH_SHORT).show();
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

    //城市筛选的回传
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                Log.e("TAG", city);
                current_city.setText(city);
            }
        }

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
                        draw.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.pet:
                        Toast.makeText(HomeActivity.this, "宠物", Toast.LENGTH_SHORT).show();
                        draw.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.order_details:
                        Toast.makeText(HomeActivity.this, "订单", Toast.LENGTH_SHORT).show();
                        draw.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.collection_account:
                        Toast.makeText(HomeActivity.this, "钱包", Toast.LENGTH_SHORT).show();
                        draw.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.about:
                        Toast.makeText(HomeActivity.this, "需知", Toast.LENGTH_SHORT).show();
                        draw.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.perfect_information:
                        //跳转到设置界面
                        Intent intent = new Intent(HomeActivity.this, SetActivity.class);
                        startActivity(intent);
                        draw.closeDrawer(GravityCompat.START);
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

    @Override
    protected void onResume() {
        super.onResume();
        isLogin();
    }
    public void isLogin(){
        if(UserManager.getIntance().isLogin()){
            icon.setVisibility(View.VISIBLE);
            ago.setVisibility(View.GONE);
        }
        else {
            icon.setVisibility(View.GONE);
            ago.setVisibility(View.VISIBLE);
        }
    }
}
