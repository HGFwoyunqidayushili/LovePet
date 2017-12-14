package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.widget.EditText;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class NickNameActivity extends BaseActivity {

    private CustomTextLayout App_title;
    private EditText pet_name;
    @Override
    protected void initView() {
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("名称","#353535");
        App_title.setRightTv("保存","#353535");
        pet_name= (EditText) findViewById(R.id.pet_name);
           initLisener();
    }

    private void initLisener() {
     App_title.setOnTextViewClickListener(new CustomTextLayout.OnTextViewClickListener()
     {
         @Override
         public void OnRightTvClick() {
             super.OnRightTvClick();
             Intent intent=new Intent();
             String name=pet_name.getText().toString().trim();
             intent.putExtra("name",name);
             setResult(RESULT_OK,intent);
             finish();
         }
     }

     );
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nick_name;
    }
}
