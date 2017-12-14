package jiyun.com.lovepet.ui.pet.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.ui.order.adapter.OrderPagerAdapter;
import jiyun.com.lovepet.ui.pet.fragment.CatFragment;
import jiyun.com.lovepet.ui.pet.fragment.DogFragment;
import jiyun.com.lovepet.ui.pet.fragment.SmallPetFragment;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class PetkindActivity extends BaseActivity {
     private CustomTextLayout App_title;
     private TabLayout tabLayout;
     private ViewPager viewPager;
     private ArrayList<String> Title_list;
     private ArrayList<Fragment> Fragment_list;
    @Override
    protected void initView() {
        tabLayout= (TabLayout) findViewById(R.id.Tab_layout);
        viewPager= (ViewPager) findViewById(R.id.view_Pager);
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("宠物类型","#353535");
        Title_list=new ArrayList<>();
        Fragment_list=new ArrayList<>();
    }

    @Override
    protected void initData() {
        Title_list.add("狗");
        Title_list.add("猫");
        Title_list.add("小宠");
        Fragment_list.add(new DogFragment());
        Fragment_list.add(new CatFragment());
        Fragment_list.add(new SmallPetFragment());
        OrderPagerAdapter pagerAdapter=new OrderPagerAdapter(getSupportFragmentManager(),Title_list,Fragment_list);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_petkind;
    }
}
