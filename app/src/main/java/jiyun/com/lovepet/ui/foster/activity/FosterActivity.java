package jiyun.com.lovepet.ui.foster.activity;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.cxp.CloudUser;
import jiyun.com.lovepet.cxp.PulldataHandler;
import jiyun.com.lovepet.cxp.PushDataListener;
import jiyun.com.lovepet.entity.PetTypeVO;
import jiyun.com.lovepet.entity.ServicePricingInfo;
import jiyun.com.lovepet.entity.ServicePricingInfoVO;
import jiyun.com.lovepet.entity.user.UserInfo;
import jiyun.com.lovepet.imagepicker.bean.ImageItem;
import jiyun.com.lovepet.manager.UserManager;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.AppUtils;
import jiyun.com.lovepet.utils.CJSON;
import jiyun.com.lovepet.utils.CutPhotoUtils;
import jiyun.com.lovepet.utils.FileUtil;
import jiyun.com.lovepet.utils.UploadUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FosterActivity extends BaseActivity {
    private EditText name, phone, city, address, identity, famile, desc;
    private LinearLayout choose_city;
    private ImageView identity_icon, yingye_icon;
    private List<PetTypeVO> petTypeVOs = new ArrayList<>();
    private List<ServicePricingInfo> servicePricingInfos = new ArrayList<>();
    private ListView petFosterListView, petServiceListView;
    private Map<String, PetTypeVO> map_foster = new HashMap<String, PetTypeVO>();
    private Map<String, ServicePricingInfo> map_service = new HashMap<String, ServicePricingInfo>();
    private FosterApplyAdapter adapter_foster;
    private FosterApplyAdapter adapter_service;
    private PopupWindow pw;
   // private SelectPhotoGridview gridview;
    private List<String> dataFile = new ArrayList<>();
    private File identity_ic, yingye_ic;
    private Button btn_ok;
    //List<IntentData> item_ic = new ArrayList<>();
    private Map<String, Object> params;
    private Map<String, File> paramss;
    private CheckBox fosterapply_cb;
    private PulldataHandler handler;
    private String setIdentify = "0";

    @Override
    protected void initView() {
        name = (EditText) findViewById(R.id.fosterapply_name);
        phone = (EditText) findViewById(R.id.fosterapply_phones);
        city = (EditText) findViewById(R.id.fosterapply_city);
        address = (EditText) findViewById(R.id.fosterapply_addres);
        choose_city = (LinearLayout) findViewById(R.id.fosterapply_choose_city);
        identity = (EditText) findViewById(R.id.fosterapply_identity);
        identity_icon = (ImageView) findViewById(R.id.fosterapply_identity_icon);
        yingye_icon = (ImageView) findViewById(R.id.fosterapply_yingye_icon);
        petFosterListView = (ListView) findViewById(R.id.fosterapply_listview_foster);
        petServiceListView = (ListView) findViewById(R.id.fosterapply_listview_service);
       // gridview = (SelectPhotoGridview) findViewById(R.id.fosterapply_spg);
        famile = (EditText) findViewById(R.id.fosterapply_nc_name);
        desc = (EditText) findViewById(R.id.fosterapply_js);
        btn_ok = (Button) findViewById(R.id.fosterapply_btn);
        fosterapply_cb = (CheckBox) findViewById(R.id.fosterapply_cb);
        identity_icon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                CutPhotoUtils.start(FosterActivity.this,
                        new CutPhotoUtils.onGetCutPhotoCallBack() {
                            @Override
                            public void photoDatas(List<ImageItem> item) {
                                if (item.isEmpty()) {
                                    return;
                                }

                                Bitmap map = BitmapFactory.decodeFile(item
                                        .get(0).path);
                                identity_icon.setImageBitmap(map);
                                identity_ic = new File(item.get(0).path);
                            }
                        });
            }
        });
        yingye_icon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                CutPhotoUtils.start(FosterActivity.this,
                        new CutPhotoUtils.onGetCutPhotoCallBack() {
                            @Override
                            public void photoDatas(List<ImageItem> item) {
                                if (item.isEmpty()) {
                                    return;
                                }

                                Bitmap map = BitmapFactory.decodeFile(item
                                        .get(0).path);
                                yingye_icon.setImageBitmap(map);
                                yingye_ic = new File(item.get(0).path);
                            }
                        });
            }
        });
        showPetType();
        showAllService();
        pw = new PopupWindow(FosterActivity.this);
    }

    private void showAllService() {

    }

    private void showPetType() {
        OkHttpClient  okhttpclient=new OkHttpClient();
        Map<String, Object> params = new HashMap<>();
        params.put("petTypeCode", "");
        params.put("beginIndex", "1");
        params.put("endIndex", "10");

        // 生成json字符串
        String josn = CJSON.toJSONMap(params);
        FormBody.Builder body=new FormBody.Builder();
         body.add(CJSON.DATA,josn);
        Request request=new Request.Builder().url(CJSON.URL_STRING).post(body.build()).build();
          okhttpclient.newCall(request).enqueue(new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {

              }

              @Override
              public void onResponse(Call call, final Response response) throws IOException {
                  App.baseActivity.runOnUiThread(new Runnable() {
                      String str=response.body().string();
                      @Override
                      public void run() {
//                          if (CJSON.getRET(str)) {
//
//                              petTypeVOs = CJSON.parseArray(
//                                      CJSON.getDESC(str), PetTypeVO.class);
//                              Log.d("TAG", petTypeVOs.toString() + "+++++");
//                              adapter_foster = new FosterApplyAdapter(petTypeVOs, null,
//                                      FosterActivity.this);
//                              petFosterListView.setAdapter(adapter_foster);
//                              setListViewHeight(petFosterListView);
//                          } else {
//
//                          }
                      }
                  });

              }
          });


    }

    @Override
    public void initData(String str) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_foster;
    }
    class FosterApplyAdapter extends BaseAdapter {
        private List<PetTypeVO> list;
        private List<ServicePricingInfo> list2;
        private Context context;

        public FosterApplyAdapter(List<PetTypeVO> list,
                                  List<ServicePricingInfo> list2, Context context) {
            this.context = context;
            this.list = list;
            this.list2 = list2;

        }

        @Override
        public int getCount() {

            return list != null && list.size() > 0 ? list.size() : list2.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(
                    R.layout.layout_fosterapply_list_items, null);
            if (list != null && list.size() > 0) {
                final CheckBox cb = (CheckBox) view
                        .findViewById(R.id.fosterapply_ls_cb);
                final TextView tv_price = (TextView) view
                        .findViewById(R.id.fosterapply_price);
                TextView tv_pet = (TextView) view
                        .findViewById(R.id.fosterapply_pet);

                cb.setText(list.get(position).getTypeName());
                tv_pet.setText("");
                view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        Boolean state = cb.isChecked();
                        if (state) {
                            cb.setChecked(false);
                            map_foster.remove(list.get(position).getTypeCode());
                            Map<String, ServicePricingInfo> ssMap = new HashMap<>();
                            for (Map.Entry<String, ServicePricingInfo> entry : map_service
                                    .entrySet()) {

                                if (!entry
                                        .getValue()
                                        .getPetTypeCode()
                                        .equals(list.get(position)
                                                .getTypeCode())) {
                                    // map_service.remove(entry.getKey());
                                    ssMap.put(entry.getKey(), entry.getValue());
                                }
                                map_service = ssMap;
                                adapter_service.notifyDataSetChanged();
                                // showAllService();
                            }
                        } else {

                            LinearLayout layout_view = (LinearLayout) LayoutInflater
                                    .from(FosterActivity.this).inflate(
                                            R.layout.layout_fosterapply_pw,
                                            null);
                            final String[] num = list.get(position)
                                    .getPetPrice().split(",");
                            for (int i = 0; i < num.length; i++) {
                                final TextView tView = new TextView(
                                        FosterActivity.this);
                                tView.setText(num[i]);
                                tView.setTextSize(20);
                                tView.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View arg0) {
                                        // ToastUtil.show(tView.getText().toString());
                                        pw.dismiss();
                                        cb.setChecked(true);
                                        tv_price.setText(tView.getText()
                                                + "元/天");
                                        PetTypeVO ss = list.get(position);
                                        ss.setPetPrice(tView.getText()
                                                .toString().trim());
                                        list.get(position).setUsersId(
                                                AppUtils.userInfo.getUserId());
                                        map_foster.put(list.get(position)
                                                .getTypeCode(), ss);
                                    }
                                });
                                LinearLayout.LayoutParams pam = new LinearLayout.LayoutParams(
                                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                                        50);
                                pam.gravity = Gravity.CENTER_HORIZONTAL;
                                pam.gravity = Gravity.CENTER;
                                // pam.addRule(RelativeLayout.CENTER_HORIZONTAL);

                                layout_view.addView(tView, pam);

                            }
                            pw.setContentView(layout_view);
                            // 设置宽和高
                            pw.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
                            pw.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
                            // // //设置背景
                            Drawable background = new ColorDrawable(Color
                                    .parseColor("#ffffff"));

                            pw.setBackgroundDrawable(background);
                            // //设置当前窗体可以获取焦点 作用：点击窗体其他位置能让窗体消失
                            pw.setFocusable(true);
                            // //设置弹出的动画效果
                            // //pw.setAnimationStyle(animationStyle);
                            // //在此控件下方显示
                            // pw.showAsDropDown(view, 0, 20);
                            // //在当前控件的正中心显示
                            pw.showAtLocation(layout_view, Gravity.BOTTOM, 0, 0);
                        }
                    }
                });

            } else {
                final CheckBox cb = (CheckBox) view
                        .findViewById(R.id.fosterapply_ls_cb);
                final TextView tv_price = (TextView) view
                        .findViewById(R.id.fosterapply_price);
                TextView tv_pet = (TextView) view
                        .findViewById(R.id.fosterapply_pet);
                cb.setText(list2.get(position).getServiceName());
                tv_pet.setText("(" + list2.get(position).getPetTypeName() + ")");
                // tv_price.setText(list2.get(position).getServicePrice()+list2.get(position).getUnit());

                // Log.d("TAG", map_service.toString()+"===========");
                if (map_service.get(list2.get(position).getServiceCode()) != null) {
                    cb.setChecked(true);
                }

                view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        Boolean state = cb.isChecked();
                        if (state) {
                            cb.setChecked(false);
                            map_service.remove(list2.get(position)
                                    .getServiceCode());

                        } else {
                            if (map_foster.get(list2.get(position)
                                    .getPetTypeCode()) != null) {
                                LinearLayout layout_view = (LinearLayout) LayoutInflater
                                        .from(FosterActivity.this)
                                        .inflate(
                                                R.layout.layout_fosterapply_pw,
                                                null);
                                final String[] num = list2.get(position)
                                        .getServicePrice().split(",");
                                for (int i = 0; i < num.length; i++) {
                                    final TextView tView = new TextView(
                                            FosterActivity.this);
                                    tView.setText(num[i]);
                                    tView.setTextSize(20);
                                    tView.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View arg0) {
                                            // ToastUtil.show(tView.getText().toString());
                                            pw.dismiss();
                                            cb.setChecked(true);
                                            tv_price.setText(tView.getText()
                                                    + list2.get(position)
                                                    .getUnit());

                                            ServicePricingInfo ssInfo = list2
                                                    .get(position);
                                            ssInfo.setServicePrice(tView
                                                    .getText().toString()
                                                    .trim());
                                            map_service.put(list2.get(position)
                                                    .getServiceCode(), ssInfo);

                                        }
                                    });
                                    LinearLayout.LayoutParams pam = new LinearLayout.LayoutParams(
                                            android.widget.LinearLayout.LayoutParams.FILL_PARENT,
                                            50);
                                    pam.gravity = Gravity.CENTER_HORIZONTAL;
                                    pam.gravity = Gravity.CENTER;
                                    // pam.addRule(RelativeLayout.CENTER_HORIZONTAL);

                                    layout_view.addView(tView, pam);
                                }
                                pw.setContentView(layout_view);
                                // 设置宽和高
                                pw.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
                                pw.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
                                // // //设置背景
                                Drawable background = new ColorDrawable(Color
                                        .parseColor("#ffffff"));

                                pw.setBackgroundDrawable(background);
                                // //设置当前窗体可以获取焦点 作用：点击窗体其他位置能让窗体消失
                                pw.setFocusable(true);
                                // //设置弹出的动画效果
                                // //pw.setAnimationStyle(animationStyle);
                                // //在此控件下方显示
                                // pw.showAsDropDown(view, 0, 20);
                                // //在当前控件的正中心显示
                                pw.showAtLocation(layout_view, Gravity.BOTTOM,
                                        0, 0);

                            } else {

                            }

                        }
                    }
                });
            }

            return view;
        }
    }
    public void    setListViewHeight(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(1, 1);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1))
                + listView.getPaddingTop() + listView.getPaddingBottom();
        listView.setLayoutParams(par);
    }
    private void fosterApply(final String id) {
        UserInfo userInfo = new UserInfo();
        List<PetTypeVO> s1 = new ArrayList<>();
        for (Map.Entry<String, PetTypeVO> entry : map_foster.entrySet()) {
            s1.add(entry.getValue());
        }
        Log.d("TAG", s1.toString() + "s1++++++++++");
        List<ServicePricingInfoVO> s2 = new ArrayList<>();
        for (Map.Entry<String, ServicePricingInfo> entry : map_service.entrySet()) {
            ServicePricingInfoVO aa = new ServicePricingInfoVO();
            aa.setServiceCode(entry.getValue().getServiceCode());
            aa.setServicePrice(entry.getValue().getServicePrice());
            aa.setUserId(AppUtils.userInfo.getUserId());
            aa.setServiceName(entry.getValue().getServiceName());
            aa.setUnit(entry.getValue().getUnit());
            s2.add(aa);
        }
        Log.d("TAG", s2.toString() + "s2++++++++++");

        String[] ct = city.getText().toString().trim().split("-");
        userInfo.setCityId(ct[1]);
        userInfo.setState(1);
        userInfo.setUserId(AppUtils.userInfo.getUserId());
        userInfo.setIdentityCard(identity.getText().toString().trim());
        userInfo.setAddress(address.getText().toString().trim());
        userInfo.setFamily(famile.getText().toString().trim());
        userInfo.setIntro(desc.getText().toString().trim());
        userInfo.setCoordX("26.091549");
        userInfo.setCoordY("119.30591");
        userInfo.setIdentify(id);
        userInfo.setRealName(name.getText().toString().trim());
        userInfo.setPetTypeVOs(s1);
        userInfo.setServicePricingInfoVOs(s2);
        params = new HashMap<>();
        params.put("UserInfoVO", userInfo);

        paramss = new HashMap<>();
        paramss.put("businessLicense" + "-" + AppUtils.userInfo.getUserId(),
                yingye_ic);
        paramss.put("identityImage" + "-" + AppUtils.userInfo.getUserId(),
                identity_ic);

//        for (int i = 0; i < item_ic.size(); i++) {
//            if (!item_ic.get(i).filePath.isEmpty()) {
//                paramss.put("image" + "-" + AppUtils.userInfo.getUserId() + "-"
//                        + i, new File(item_ic.get(i).filePath));
//            }
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                String result = UploadUtil.uploadFile(paramss,
                        AppUtils.REQUESTURL + "users/saveUsersInfos.jhtml",
                        params);
                Log.d("TAG", result + "-------------------------------------");
                Log.d("TAG", "-------------------------------------");
                if (CJSON.getRET(result)) {
                    runOnUiThread(new Runnable() {
                        public void run() {

                            FosterActivity.this.finish();

                            AppUtils.userInfo.setState(1);
                            AppUtils.userInfo.setIdentify(id);
                            FileUtil.saveUser(AppUtils.userInfo);
                        }
                    });
                } else {

                }
            }
        }).start();
    }



    private void cxp() {
        CloudUser user = new CloudUser();

        user.set_name(famile.getText().toString());
        user.set_address(address.getText().toString().trim());
        double doubleLon = 0;
        double doubleLat = 0;
        try {
            String strLon = "116.249107";
            doubleLon = AppUtils.parseDouble(Double.parseDouble(strLon));
            String strLat = "40.117361";
            doubleLat = AppUtils.parseDouble(Double.parseDouble(strLat));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        user.set_location(doubleLon + "," + doubleLat);
        user.setState("1");
        user.setUsersId(UserManager.getIntance().getUserId());
        user.setPhoto("");
        handler = new PulldataHandler(new PushDataListener() {

            @Override
            public void onPushFinish(boolean succeed, String errorDes, String id) {
                Log.d("TAG", id + "=====");
                fosterApply(id);
            }
        }, "create");
        handler.addTask(user);
    }
}
