package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.manager.UserManager;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CJSON;
import jiyun.com.lovepet.utils.CustomTextLayout;
import jiyun.com.lovepet.utils.TableUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyPetActivity extends BaseActivity{

    private CustomTextLayout App_title;
    private ListView lv;
    private UserManager userManager;

//
//
//

    @Override
    protected void initView() {
        userManager=UserManager.getIntance();
        lv= (ListView) findViewById(R.id.lv);
        App_title = (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("我的宠物","#353535");
        App_title.setRightTv("添加宠物","#353535");
        App_title.setOnTextViewClickListener(new CustomTextLayout.OnTextViewClickListener(){
            @Override
            public void OnRightTvClick() {
                super.OnRightTvClick();
                Intent intent=new Intent(MyPetActivity.this,AddPetActivity.class);
                startActivity(intent);

            }
        });
        Map<String,Object> map=new HashMap<>();
        OkHttpClient okHttpClient=new OkHttpClient();

         map.put(TableUtils.UserInfo.USERID,userManager.getUserId());

        String json=CJSON.toJSONMap(map);
        FormBody.Builder body=new FormBody.Builder();
         body.add(CJSON.DATA,json);
        Request request=new Request.Builder().url(CJSON.URL_STRING+"petInfo/getPetInfoByUserId.jhtml")
                                             .post(body.build()).build();
         okHttpClient.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 Log.e("TAG",response.body().string());
             }
         });


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_pet;
    }


}
