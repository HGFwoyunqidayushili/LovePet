package jiyun.com.lovepet.ui.pet.activity;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class MyPetActivity extends BaseActivity {

    private CustomTextLayout App_title;



    @Override
    protected void initView() {

        App_title = (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("我的宠物","#353535");



    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_pet;
    }
}
