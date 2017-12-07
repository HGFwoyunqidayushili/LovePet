package jiyun.com.lovepet.ui;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {
        CustomTextLayout customTextLayout= (CustomTextLayout) findViewById(R.id.App_title);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
          return R.layout.activity_main;
    }
}
