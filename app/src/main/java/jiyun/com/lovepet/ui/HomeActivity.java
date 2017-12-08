package jiyun.com.lovepet.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.mvp.presenter.HomePresenter;
import jiyun.com.lovepet.mvp.view.HomeView;
import jiyun.com.lovepet.ui.adapter.HomeAdapter;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class HomeActivity extends BaseActivity implements HomeView {
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<String> strings1 = new ArrayList<>();

    private NavigationView nav_view;
    private EditText editText;
    private ImageView imageView;
    private DrawerLayout draw;
    private ListView listView1;
    private ListView listView2;
    private TextView fuJin;
    private TextView jiGE;
    private ToggleButton shaixuan1;
    private ToggleButton shaixuan2;
    private View viewById1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//加载布局
        initView();//寻找控件
        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.getgetDatatoView();
        initData();//点击跳转到各个界面
        initLinnser();//用户点击listView事件
    }

    private void initLinnser() {
       listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               fuJin.setText(strings1.get(i));

           }
       });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                jiGE.setText(strings.get(i));

            }
        });
        shaixuan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shaixuan1.isChecked()){
                    listView1.setVisibility(View.VISIBLE);

                }else {
                    listView1.setVisibility(View.GONE);

                }
            }
        });
        shaixuan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (shaixuan2.isChecked()){

                    listView2.setVisibility(View.VISIBLE);

                }else {
                    listView2.setVisibility(View.GONE);
                }
            }
        });

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

        listView1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
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
        fuJin = viewById1.findViewById(R.id.fuJin);
        jiGE = viewById1.findViewById(R.id.jiaGe);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "用户登录界面", Toast.LENGTH_SHORT).show();
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

    //用户筛选界面
    @Override
    public void getData(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        strings.addAll(arrayList2);
        strings1.addAll(arrayList);
        HomeAdapter homeAdapter = new HomeAdapter(arrayList2, HomeActivity.this);

        HomeAdapter homeAdapter1 = new HomeAdapter(arrayList, HomeActivity.this);
        listView2.setAdapter(homeAdapter);
        listView1.setAdapter(homeAdapter1);
    }
}
