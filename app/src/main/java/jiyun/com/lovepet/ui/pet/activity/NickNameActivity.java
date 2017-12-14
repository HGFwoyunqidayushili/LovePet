package jiyun.com.lovepet.ui.pet.activity;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class NickNameActivity extends BaseActivity {

    private CustomTextLayout App_title;
    @Override
    protected void initView() {
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("名称","#353535");
        App_title.setRightTv("保存","#353535");

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nick_name;
    }
}
