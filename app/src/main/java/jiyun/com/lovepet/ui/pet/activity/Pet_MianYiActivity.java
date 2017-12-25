package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.Imm;
import jiyun.com.lovepet.entity.pet.ImmuneInfo;
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

public class Pet_MianYiActivity extends BaseActivity implements View.OnClickListener {

     private CustomTextLayout App_title;
     private Drawable leftDrawable;
     private Button button1,button2,button3,getButton3,button4;
    private List<Imm> valueslist = null;
    private List<Imm> datalist = null;
    private List<ImmuneInfo> jiulist=null;
    private String path;
    private TextView time;
    private RelativeLayout mTv_time;

    @Override
    protected void initView() {
        Resources res = getResources();
        leftDrawable=res.getDrawable(R.drawable.imm_check);
         leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(),
                 leftDrawable.getMinimumHeight());
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("免疫情况", "#353535");
        App_title.setRightTv("确定", "#353535");
        time= (TextView) findViewById(R.id.time);
        mTv_time= (RelativeLayout) findViewById(R.id.mTv_time);
        mTv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeclectorDateActivity.startActivity(Pet_MianYiActivity.this, "选择日期",
                        new SeclectorDateActivity.OnGetDateListener() {
                            @Override
                            public void dateChange(String date) {
                             time.setText(date);
                            }
                        });
            }
        });

        //初始化免疫病毒左边的图片

        button1= (Button) findViewById(R.id.virus1);
        button2= (Button) findViewById(R.id.virus2);
        button3= (Button) findViewById(R.id.virus3);
        button4= (Button) findViewById(R.id.virus4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        if (getIntent().getStringExtra("petimmlist") != null) {
            String petimmlist = getIntent().getStringExtra("petimmlist");
            jiulist = CJSON.parseArray(petimmlist, ImmuneInfo.class);
        }
        //查询免疫信息
          querymianyiInfo();
        App_title.setOnTextViewClickListener(new CustomTextLayout.OnTextViewClickListener(){
            @Override
            public void OnRightTvClick() {
                super.OnRightTvClick();
                Intent intent=new Intent();
                 if(time.getText().toString().isEmpty()){
                     showToast("请选择上次免疫时间");
                     return;
                 }
                if(valueslist==null){
                    return;
                }
                for (Imm imm : valueslist) {
                    imm.setImmuneTime(time.getText().toString());
                }
                String list = CJSON.toJSONString(valueslist);
                intent.putExtra("list", list);
                Log.i("TAG", "=======1=======" + list);
                   showToast("上传成功");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void querymianyiInfo() {
        OkHttpClient okhttp=new OkHttpClient();
        Map<String,Object> map=new HashMap<>();
          map.put(TableUtils.ImmuneInfo.ISUSE,1+"");
        final String json = CJSON.toJSONMap(map);
        FormBody.Builder builder=new FormBody.Builder();
          builder.add(CJSON.DATA, json);
        Request request=new Request.Builder().url(CJSON.URL_STRING+"immuneInfo/getImmuneInfos.jhtml").post(builder.build()).build();
             okhttp.newCall(request).enqueue(new Callback() {
                 @Override
                 public void onFailure(Call call, IOException e) {

                 }

                 @Override
                 public void onResponse(Call call, final Response response) throws IOException {
                     String str=response.body().string();
                     if(CJSON.getRET(str)) {
                         String desc = CJSON.getDESC(str);
                         datalist = CJSON.parseArray(desc, Imm.class);
                     }
                     App.baseActivity.runOnUiThread(new Runnable() {
                         @Override
                         public void run() {


                             button1.setText(datalist.get(0).getImmuneName());
                             button2.setText(datalist.get(1).getImmuneName());
                             button3.setText(datalist.get(2).getImmuneName());
                             button4.setText(datalist.get(3).getImmuneName());
                             if(jiulist!=null){
                                 for(int i=0;i<jiulist.size();i++){
                                     for(int y=0;y<jiulist.size();y++){
                                         if(jiulist.get(i).getImmuneCode().equals(datalist.get(y).getImmuneCode())){

                                             switch (y){
                                                 case 0:
                                                     button1.setCompoundDrawables(leftDrawable, null, null,
                                                             null);
                                                     button1.setOnClickListener(obclick);
                                                     break;
                                                 case 1:
                                                     button2.setCompoundDrawables(leftDrawable, null, null,
                                                             null);
                                                     button2.setOnClickListener(obclick);
                                                     break;
                                                 case 2:
                                                     button3.setCompoundDrawables(leftDrawable, null, null,
                                                             null);
                                                     button3.setOnClickListener(obclick);
                                                     break;
                                                 case 3:

                                                     button4.setCompoundDrawables(leftDrawable, null, null,
                                                             null);
                                                     button4.setOnClickListener(obclick);
                                                     break;
                                             }
                                         }
                                         else {
                                             showToast("没有免疫信息");
                                         }

                                     }
                                 }
                             }


                         }
                     });
                 }
             });
    }

    @Override
    public void initData(String s) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet__mian_yi;

    }

    @Override
    public void onClick(View view) {
        if (valueslist == null) {
            valueslist = new ArrayList<>();
        }
        Imm i = null;

        switch (view.getId()){
            case R.id.virus1:
                button1.setCompoundDrawables(leftDrawable, null, null,
                        null);
                for (Imm imm : valueslist) {
                    if (imm.getImmuneCode() == datalist.get(0)
                            .getImmuneCode()) {
                        i = imm;
                    }
                }
                if (i == null) {
                    i = new Imm();
                    i.setImmuneCode(datalist.get(0).getImmuneCode());
                    i.setImmuneName(datalist.get(0).getImmuneName());
                }
                break;
            case R.id.virus2:
                button2.setCompoundDrawables(leftDrawable, null, null,
                        null);
                for (Imm imm : valueslist) {
                    if (imm.getImmuneCode() == datalist.get(1)
                            .getImmuneCode()) {
                        i = imm;

                    }
                }
                if (i == null) {
                    i = new Imm();
                    i.setImmuneCode(datalist.get(1).getImmuneCode());

                    i.setImmuneName(datalist.get(1).getImmuneName());
                }
                break;
            case R.id.virus3:
                button3.setCompoundDrawables(leftDrawable, null, null,
                        null);
                for (Imm imm : valueslist) {
                    if (imm.getImmuneCode() == datalist.get(2)
                            .getImmuneCode()) {
                        i = imm;
                    }
                }
                if (i == null) {
                    i = new Imm();
                    i.setImmuneCode(datalist.get(2).getImmuneCode());
                    i.setImmuneName(datalist.get(2).getImmuneName());
                }
                break;
            case R.id.virus4:
                button4.setCompoundDrawables(leftDrawable, null, null,
                        null);
                for (Imm imm : valueslist) {
                    if (imm.getImmuneCode() == datalist.get(3)
                            .getImmuneCode()) {
                        i = imm;

                    }
                }
                if (i == null) {
                    i = new Imm();
                    i.setImmuneCode(datalist.get(3).getImmuneCode());
                    i.setImmuneName(datalist.get(3).getImmuneName());
                }
                break;

        }
        valueslist.add(i);
    }
    View.OnClickListener obclick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showToast("图片只能上传一次");
        }
    };
}
