package jiyun.com.lovepet.ui.order.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.lovepet.R;

public class MyOrderActivity extends AppCompatActivity {

    private TabLayout Tab_order;
    private ViewPager order_pager;
    private List<String> TitleList;
    private List<Fragment> FragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        TitleList=new ArrayList<>();
        FragmentList=new ArrayList<>();
        initView();
        initData();

    }

    private void initData() {
        TitleList.add("全部");
        TitleList.add("待确认");
        TitleList.add("寄养中");
        TitleList.add("待评价");


    }

    private void initView() {
        Tab_order = (TabLayout) findViewById(R.id.Tab_order);
        order_pager = (ViewPager) findViewById(R.id.order_pager);
    }
}
