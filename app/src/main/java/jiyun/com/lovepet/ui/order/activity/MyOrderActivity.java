package jiyun.com.lovepet.ui.order.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.ui.order.adapter.OrderPagerAdapter;
import jiyun.com.lovepet.ui.order.fragment.AllorderFragment;
import jiyun.com.lovepet.ui.order.fragment.FostercareFragment;
import jiyun.com.lovepet.ui.order.fragment.WaitConfirmFragment;
import jiyun.com.lovepet.ui.order.fragment.WaitEvaluatedFragment;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class MyOrderActivity extends BaseActivity {

    private TabLayout Tab_order;
    private ViewPager order_pager;
    private List<String> TitleList;
    private List<Fragment> FragmentList;
    private CustomTextLayout App_title;
    @Override
    protected void initView() {
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setCenterTv("我的订单","#353535");
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        Tab_order= (TabLayout) findViewById(R.id.Tab_order);
        order_pager= (ViewPager) findViewById(R.id.order_pager);
        TitleList=new ArrayList<>();
        FragmentList=new ArrayList<>();
    }


    @Override
    public void initData(String str) {
        TitleList.add("全部");
        TitleList.add("待确认");
        TitleList.add("寄养中");
        TitleList.add("待评价");
        FragmentList.add(new AllorderFragment());
        FragmentList.add(new WaitConfirmFragment());
        FragmentList.add(new FostercareFragment());
        FragmentList.add(new WaitEvaluatedFragment());
        OrderPagerAdapter orderPagerAdapter=new OrderPagerAdapter(getSupportFragmentManager(),TitleList,FragmentList);
        order_pager.setAdapter(orderPagerAdapter);
        Tab_order.setupWithViewPager(order_pager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_order;
    }


}
