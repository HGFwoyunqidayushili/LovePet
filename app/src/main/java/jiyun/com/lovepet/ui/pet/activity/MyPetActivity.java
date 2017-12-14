package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class MyPetActivity extends BaseActivity implements View.OnClickListener{

    private CustomTextLayout App_title;
    private Button add_pet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet);
        initView();
    }
//
//
//

    @Override
    protected void initView() {

        App_title = (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("我的宠物","#353535");
        add_pet= (Button) findViewById(R.id.add_pet);
        add_pet.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_pet;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_pet:
                Intent intent=new Intent(this,AddPetActivity.class);
                startActivity(intent);
                break;
        }
    }
}
