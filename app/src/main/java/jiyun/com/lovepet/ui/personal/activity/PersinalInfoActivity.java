package jiyun.com.lovepet.ui.personal.activity;

import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;

public class PersinalInfoActivity extends BaseActivity implements View.OnClickListener {


    private CustomTextLayout App_title;
    private RelativeLayout relativeLayout;
    private PopupWindow popupWindow;
    private View Mypup;
    @Override
    protected void initView() {
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("个人信息","#353535");
        relativeLayout= (RelativeLayout) findViewById(R.id.header_icon);
        relativeLayout.setOnClickListener(this);
        Mypup= LayoutInflater.from(this).inflate(R.layout.popupwindow,null);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_persinal_info;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.header_icon:
                popupWindow=new PopupWindow(Mypup, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
                popupWindow.setFocusable(true);
                ColorDrawable dw = new ColorDrawable(0xb0000000);
                // 设置弹出窗体的背景
                popupWindow.setBackgroundDrawable(dw);
                popupWindow.showAtLocation(Mypup, Gravity.BOTTOM,0,0);
                break;
        }

    }
}
