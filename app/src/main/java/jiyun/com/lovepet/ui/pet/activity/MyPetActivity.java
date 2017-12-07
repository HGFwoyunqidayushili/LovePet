package jiyun.com.lovepet.ui.pet.activity;

import android.os.Bundle;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class MyPetActivity extends BaseActivity {

    private CustomTextLayout App_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet);
        initView();
    }

    @Override
    protected void initView() {

        App_title = (CustomTextLayout) findViewById(R.id.App_title);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
