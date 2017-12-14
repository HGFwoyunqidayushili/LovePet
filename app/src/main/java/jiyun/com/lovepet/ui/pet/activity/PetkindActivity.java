package jiyun.com.lovepet.ui.pet.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class PetkindActivity extends BaseActivity {
     private CustomTextLayout App_title;
     private TabLayout tabLayout;
     private ViewPager viewPager;

    @Override
    protected void initView() {

        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("宠物类型","#353535");

    }

    @Override
    protected void initData() {

    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_petkind;
    }
}
