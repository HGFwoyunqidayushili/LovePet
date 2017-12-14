package jiyun.com.lovepet.ui.wallet.activity;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class MyWalletActivity extends BaseActivity {

   private CustomTextLayout App_title ;
    @Override
    protected void initView() {
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("我的钱包","#353535");
        App_title.setRightTv("交易记录","#353535");


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_wallet;
    }
}
