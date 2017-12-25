package jiyun.com.lovepet.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.lovepet.Demo;
import jiyun.com.lovepet.HomeBean;
import jiyun.com.lovepet.ListViewHomeAdapter;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.bean.PetBean;
import jiyun.com.lovepet.http.OkHttpUtils;
import jiyun.com.lovepet.mvp.contract.Contract;
import jiyun.com.lovepet.mvp.presenter.InfoPresenter;
import jiyun.com.lovepet.ui.personal.activity.PersinalInfoActivity;
import jiyun.com.lovepet.ui.pet.activity.JiYangShiXiangQing;
import jiyun.com.lovepet.ui.pet.activity.MapActivity;
import jiyun.com.lovepet.ui.pet.activity.Need_to_knowActivity;
import jiyun.com.lovepet.ui.pet.activity.OrderActivity;
import jiyun.com.lovepet.ui.pet.activity.SetActivity;
import jiyun.com.lovepet.ui.wallet.activity.MyWalletActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class HomeActivity extends BaseActivity implements Contract.Views<jiyun.com.lovepet.HomeBean> {
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private NavigationView nav_view;
    private EditText editText;
    private ImageView imageView;
    private DrawerLayout draw;

    private final String HTTPURL1 = "http://123.56.150.230:8885/dog_family/users/getUsersInfoByVO.jhtml";
    private final String HTTPURL2 = "http://123.56.150.230:8885/dog_family/petType/getPetTypesByVO.jhtml";
    private View viewById1;
    private CheckBox shaixuan1;
    private CheckBox shaixuan2;
    private CheckBox shaixuan3;
    private View linearLayout;
    private View imagetIntentToMap;
    private PopupWindow popupWindow3;
    private PopupWindow popupWindow2;
    private PopupWindow popupWindow;
    private CheckBox current_city;
    private ListView listVirew;
    private HashMap<String, Object> mMap;
    private InfoPresenter infoPresenter;
    private Map<String, Object> petMap = new HashMap<>();
    private List<jiyun.com.lovepet.HomeBean.DescBean> descBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());//加载布局
        initView();
        initData("price asc");
        //寻找控件
        infoPresenter = new InfoPresenter(this, this);
        infoPresenter.getPostData(HTTPURL1, mMap);
        //点击跳转到各个界面\
        initListener();
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
        IntentOrder();
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
                        //钱包页面
                        startActivity(new Intent(HomeActivity.this, MyWalletActivity.class));
                        draw.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.about:
                        //需知
                        startActivity(new Intent(HomeActivity.this, Need_to_knowActivity.class));
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

    private void initListener() {
        shaixuan1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (shaixuan1.isChecked()) {
                    listVirew.setVisibility(View.GONE);
                    View popupview = LayoutInflater.from(HomeActivity.this).inflate(R.layout.mypopupwindow2, null);
                    popupWindow = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.showAsDropDown(linearLayout);
                } else {
                    popupWindow.dismiss();
                }
            }
        });
        shaixuan2.setOnClickListener(new View.OnClickListener() {


            //
            @Override
            public void onClick(View view) {
                if (shaixuan2.isChecked()) {
                    listVirew.setVisibility(View.GONE);
                    View popupview = LayoutInflater.from(HomeActivity.this).inflate(R.layout.mypopupwindow1, null);
                    popupWindow2 = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    //设置pop是否获取焦点
                    popupWindow2.setBackgroundDrawable(new BitmapDrawable());
                    //http://123.56.150.230:8885/dog_family/t_user_info

                    popupWindow2.showAsDropDown(linearLayout);
                    final RadioButton smallDog = (RadioButton) popupview.findViewById(R.id.smallDog);
                    final RadioButton inDog = (RadioButton) popupview.findViewById(R.id.inDog);
                    final RadioButton bigDog = (RadioButton) popupview.findViewById(R.id.bigDog);
                    final RadioButton Puppies = (RadioButton) popupview.findViewById(R.id.Puppies);
                    //Puppies
                    final RadioButton animal_Cat = (RadioButton) popupview.findViewById(R.id.animal_Cat);
                    //animal_Cat
                    smallDog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (smallDog.isChecked()) {
                                shaixuan2.setText("附近优先");
                                initData("distance asc");
                                infoPresenter.getPostData(HTTPURL1, mMap);
                                popupWindow2.dismiss();
                                listVirew.setVisibility(View.VISIBLE);
                            } else {

                            }
                        }
                    });
                    inDog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (inDog.isChecked()) {
                                shaixuan2.setText("好评优先");
                                initData("score desc");
                                infoPresenter.getPostData(HTTPURL1, mMap);
                                popupWindow2.dismiss();
                                listVirew.setVisibility(View.VISIBLE);
                            } else {


                            }
                        }
                    });
                    bigDog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (bigDog.isChecked()) {
                                shaixuan2.setText("订单优先");
                                initData("orderCount desc");
                                infoPresenter.getPostData(HTTPURL1, mMap);
                                popupWindow2.dismiss();
                                listVirew.setVisibility(View.VISIBLE);
                            } else {
                            }
                        }
                    });
                    animal_Cat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (animal_Cat.isChecked()) {
                                shaixuan2.setText("价格从高到低");
                                initData("price desc");
                                infoPresenter.getPostData(HTTPURL1, mMap);
                                popupWindow2.dismiss();
                                listVirew.setVisibility(View.VISIBLE);
                            } else {

                            }
                        }
                    });
                    Puppies.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (Puppies
                                    .isChecked()) {
                                shaixuan2.setText("价格从低到高");
                                initData("price asc");
                                infoPresenter.getPostData(HTTPURL1, mMap);
                                popupWindow2.dismiss();
                                listVirew.setVisibility(View.VISIBLE);
                            } else {
                                popupWindow2.dismiss();
                            }
                        }
                    });
                } else {
                    popupWindow2.dismiss();
                }
            }
        });
        shaixuan3.setOnClickListener(new View.OnClickListener() {

            private TextView intentText;

            @Override
            public void onClick(View view) {
                if (shaixuan3.isChecked()) {
                    View popupview = LayoutInflater.from(HomeActivity.this).inflate(R.layout.mypopupwindow3, null);
                    popupWindow3 = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow3.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow3.showAsDropDown(linearLayout);
                    intentText = (TextView) popupview.findViewById(R.id.intent);
                    final CheckBox take_a_bath = (CheckBox) popupview.findViewById(R.id.take_a_bath);
                    final CheckBox pick_up = (CheckBox) popupview.findViewById(R.id.pick_up);
                    final CheckBox new_Year_s_Day = (CheckBox) popupview.findViewById(R.id.new_Year_s_Day);
                    final CheckBox chinese_New_Year = (CheckBox) popupview.findViewById(R.id.chinese_New_Year);
                    final CheckBox ching_Ming_Festival = (CheckBox) popupview.findViewById(R.id.ching_Ming_Festival);
                    final CheckBox labor_day = (CheckBox) popupview.findViewById(R.id.labor_day);
                    final CheckBox dragon_Boat_Festival = (CheckBox) popupview.findViewById(R.id.dragon_Boat_Festival);
                    final CheckBox mid_Autumn_Festival = (CheckBox) popupview.findViewById(R.id.mid_Autumn_Festival);
                    final CheckBox national_Day = (CheckBox) popupview.findViewById(R.id.national_Day);
                    final Button reset = (Button) popupview.findViewById(R.id.reset);
                    reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //重置按钮
                            new_Year_s_Day.setChecked(false);
                            chinese_New_Year.setChecked(false);
                            ching_Ming_Festival.setChecked(false);
                            labor_day.setChecked(false);
                            dragon_Boat_Festival.setChecked(false);
                            mid_Autumn_Festival.setChecked(false);
                            national_Day.setChecked(false);
                            take_a_bath.setChecked(false);
                            pick_up.setChecked(false);
                        }
                    });
                    current_city = (CheckBox) popupview.findViewById(R.id.current_city);
                    intentText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(HomeActivity.this, CityPickerActivity.class);
                            startActivityForResult(intent, REQUEST_CODE_PICK_CITY);
                        }
                    });
                } else {
                    popupWindow3.dismiss();
                }
            }
        });

    }

    private void initChangedImage() {
        View headerView = nav_view.getHeaderView(0);
        RelativeLayout viewById = (RelativeLayout) headerView.findViewById(R.id.intentUserchangeImage);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, PersinalInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initLogin() {
        viewById1 = findViewById(R.id.queView);
        ImageView image = (ImageView) viewById1.findViewById(R.id.userXinXi);
        shaixuan1 = (CheckBox) viewById1.findViewById(R.id.shaixuan1);
        shaixuan2 = (CheckBox) viewById1.findViewById(R.id.shaixuan2);
        shaixuan3 = (CheckBox) viewById1.findViewById(R.id.shaixuan3);
        listVirew = (ListView) viewById1.findViewById(R.id.listView);

        linearLayout = viewById1.findViewById(R.id.ll_home);
        imagetIntentToMap = viewById1.findViewById(R.id.intentTo_Map);
        listVirew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, JiYangShiXiangQing.class);
                intent.putExtra("image", descBeen.get(position).getUserImage());
                intent.putExtra("name", descBeen.get(position).getFamily());
                intent.putExtra("id", descBeen.get(position).getUsersId());
                startActivity(intent);
            }
        });
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
    public void initData(String str) {
        mMap = new HashMap<>();
        mMap.put("beginIndex", 0);
        mMap.put("endIndex", 18);
        mMap.put("coordX", 40.116384);
        mMap.put("coordY", 116.250374);
        mMap.put("orderBy", str);
        petMap.put("beginIndex", 0);
        petMap.put("endIndex", 10);
        petMap.put("petTypeCode", "daxingquan");


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }


    @Override
    public void success(jiyun.com.lovepet.HomeBean homeBean) {
        descBeen = new ArrayList<>();
        List<jiyun.com.lovepet.HomeBean.DescBean> desc = homeBean.getDesc();
        descBeen.addAll(desc);
        ListViewHomeAdapter listViewHomeAdapter = new ListViewHomeAdapter(desc, HomeActivity.this);
        listVirew.setAdapter(listViewHomeAdapter);
    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void success1(HomeBean homeBean) {

    }

    //返回键监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setIcon(R.drawable.kawayi);

            builder.setTitle("退出程序");
            builder.setMessage("主人真的要退出吗?再考虑考虑....");
            builder.setNegativeButton("残忍退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setPositiveButton("再玩一会", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Toast.makeText(HomeActivity.this, "谢谢您喜欢我们的产品", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create();
            builder.show();


            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public void IntentOrder() {

    }
}
