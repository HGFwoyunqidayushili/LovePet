package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.bean.JiYangShiBean;
import jiyun.com.lovepet.mvp.contract.Contract;
import jiyun.com.lovepet.mvp.presenter.InfoPresenter;
import jiyun.com.lovepet.ui.wallet.activity.popup.CustomPopupWindow;

public class JiYangShiXiangQing extends AppCompatActivity implements CustomPopupWindow.OnItemClickListener,Contract.Views<JiYangShiBean> {
    private final String HTTPURL1 = "http://123.56.150.230:8885/dog_family/users/getUsersInfos.jhtml";
    private TextView userName;
    private ImageView userImage;
    private ImageView imageView3;
    private TextView pingluntv_fellow;
    private LinearLayout pinglun_fellow;
    private TextView jiage1_fellow;
    private TextView jiage2_fellow;
    private TextView jiage3_fellow;
    private TextView jiage4_fellow;
    private TextView jiage5_fellow;
    private TextView jiage6_fellow;
    private TextView jiage7_fellow;
    private TextView jiage8_fellow;
    private TextView dizhi_fellow;
    private TextView jianjie_fellow;
    private TextView lianxi_fellow;
    private TextView queding_fellow;
    private Map mMap =new HashMap();
    private LinearLayout ll_fellow;
    private ScrollView activity_ji_yang_shi_xiang_qing;
    private CustomPopupWindow customPopupWindow;
    private String name;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_yang_shi_xiang_qing);
        initView();

        customPopupWindow = new CustomPopupWindow(JiYangShiXiangQing.this);
        customPopupWindow.setOnItemClickListener(JiYangShiXiangQing.this);
        initGetIntent();
        InfoPresenter infoPresenter = new InfoPresenter(this, this);
        infoPresenter.getPostData(HTTPURL1,mMap);
    }

    private void initGetIntent() {
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        userId = intent.getStringExtra("id");
        mMap.put("userId",userId);
        name = intent.getStringExtra("name");

        if (image == null) {
            Glide.with(JiYangShiXiangQing.this).load(R.drawable.jiaziazhong).asGif().into(userImage);
        } else {
            Glide.with(JiYangShiXiangQing.this).load(image).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(userImage);
        }

        userName.setText(name);
        lianxi_fellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这个监听是要点击显示popupwindow的文字监听
                customPopupWindow.showAtLocation(lianxi_fellow, Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });
    }

    private void initView() {
        userName = (TextView) findViewById(R.id.userName);
        userImage = (ImageView) findViewById(R.id.userImage);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        pingluntv_fellow = (TextView) findViewById(R.id.pingluntv_fellow);
        pinglun_fellow = (LinearLayout) findViewById(R.id.pinglun_fellow);
        jiage1_fellow = (TextView) findViewById(R.id.jiage1_fellow);
        jiage2_fellow = (TextView) findViewById(R.id.jiage2_fellow);
        jiage3_fellow = (TextView) findViewById(R.id.jiage3_fellow);
        jiage4_fellow = (TextView) findViewById(R.id.jiage4_fellow);
        jiage5_fellow = (TextView) findViewById(R.id.jiage5_fellow);
        jiage6_fellow = (TextView) findViewById(R.id.jiage6_fellow);
        jiage7_fellow = (TextView) findViewById(R.id.jiage7_fellow);
        jiage8_fellow = (TextView) findViewById(R.id.jiage8_fellow);
        dizhi_fellow = (TextView) findViewById(R.id.dizhi_fellow);
        jianjie_fellow = (TextView) findViewById(R.id.jianjie_fellow);
        lianxi_fellow = (TextView) findViewById(R.id.lianxi_fellow);
        queding_fellow = (TextView) findViewById(R.id.queding_fellow);
        ll_fellow = (LinearLayout) findViewById(R.id.ll_fellow);
        activity_ji_yang_shi_xiang_qing = (ScrollView) findViewById(R.id.activity_ji_yang_shi_xiang_qing);
        queding_fellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JiYangShiXiangQing.this, OrderActivity.class));
            }
        });
    }


    @Override
    public void setOnItemClick(View v) {
                //popupWindow的条目的监听事件
            switch (v.getId()){
                case  R.id.tv_photograph:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"10086"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
                case R.id.tv_photo:
                    Intent intent1 = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+"10086"));
                    intent1.putExtra("sms_body", "你好!");
                    startActivity(intent1);
                    break;

            }
    }

    @Override
    public void success(JiYangShiBean jiYangShiBean) {
        JiYangShiBean.DescBean desc = jiYangShiBean.getDesc();
        List<JiYangShiBean.DescBean.FosterServicesBean> fosterServices = desc.getFosterServices();
        JiYangShiBean.DescBean.FosterInfoBean fosterInfo = desc.getFosterInfo();
        String realName = fosterInfo.getRealName();
        String address = fosterInfo.getAddress();
        dizhi_fellow.setText(address);
        userName.setText(realName);
        try {
            jianjie_fellow.setText(fosterInfo.getIntro());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<JiYangShiBean.DescBean.FosterOtherServicesBean> fosterOtherServices = desc.getFosterOtherServices();


    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void success1(JiYangShiBean jiYangShiBean) {
        JiYangShiBean.DescBean desc = jiYangShiBean.getDesc();
        JiYangShiBean.DescBean.FosterInfoBean fosterInfo = desc.getFosterInfo();
        String realName = fosterInfo.getRealName();
        String address = fosterInfo.getAddress();
        dizhi_fellow.setText(address);
        userName.setText(realName);
        List<JiYangShiBean.DescBean.FosterServicesBean> fosterServices = desc.getFosterServices();


        List<JiYangShiBean.DescBean.FosterOtherServicesBean> fosterOtherServices = desc.getFosterOtherServices();

    }


}
