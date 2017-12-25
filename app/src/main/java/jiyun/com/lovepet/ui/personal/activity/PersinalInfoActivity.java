package jiyun.com.lovepet.ui.personal.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.manager.UserManager;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.AppUtils;
import jiyun.com.lovepet.utils.CJSON;
import jiyun.com.lovepet.utils.CustomTextLayout;
import jiyun.com.lovepet.utils.FileUtil;
import jiyun.com.lovepet.utils.ImageUtils;
import jiyun.com.lovepet.utils.PhotoUtils;
import jiyun.com.lovepet.utils.TableUtils;
import jiyun.com.lovepet.utils.ToastUtil;
import jiyun.com.lovepet.utils.ToastUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PersinalInfoActivity extends BaseActivity implements View.OnClickListener {

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;

    private CustomTextLayout App_title;
    private RelativeLayout relativeLayout;
    private PopupWindow popupWindow;
    private View Mypup;
    private TextView name;
    private CircleImageView imgs;
    private TextView phone;
    private View sex;
    private TextView tv_sex;
    private View calendar;
    private Button mStartDateButton;
    private Button mEndDateButton;
    private Button mDateValidButton;
    private TextView mShowContentTextView;

    @Override
    protected void initView() {
        App_title = (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("个人信息", "#353535");
        relativeLayout = (RelativeLayout) findViewById(R.id.header_icon);
        relativeLayout.setOnClickListener(this);
        Mypup = LayoutInflater.from(this).inflate(R.layout.popupwindow, null);
        sex = LayoutInflater.from(this).inflate(R.layout.popupwindow_sex, null);
        calendar = LayoutInflater.from(this).inflate(R.layout.popupwindow_calendar, null);
        TextView phonoAlbum = Mypup.findViewById(R.id.phono_Album);
        TextView takephoto = Mypup.findViewById(R.id.take_photo);
        Button btcancel = Mypup.findViewById(R.id.bt_cancel);
        //性别
        tv_sex = (TextView) findViewById(R.id.tv_sex);


//名称的布局
        RelativeLayout parl = (RelativeLayout) findViewById(R.id.pa_rl);
        RelativeLayout rl_weichat = (RelativeLayout) findViewById(R.id.rl_weichat);
        RelativeLayout rl_qq = (RelativeLayout) findViewById(R.id.rl_qq);
        RelativeLayout rl_sex = (RelativeLayout) findViewById(R.id.rl_sex);
        RelativeLayout data = (RelativeLayout) findViewById(R.id.rl_data);
        RelativeLayout rl_con_add = (RelativeLayout) findViewById(R.id.rl_con_add);

        parl.setOnClickListener(this);
        rl_weichat.setOnClickListener(this);
        rl_qq.setOnClickListener(this);
        rl_sex.setOnClickListener(this);
        data.setOnClickListener(this);
        rl_con_add.setOnClickListener(this);

//        parl.setOnClickListener(this);


        //popupWindow 点击事件
        phonoAlbum.setOnClickListener(this);
        takephoto.setOnClickListener(this);
        btcancel.setOnClickListener(this);


        //圆形头像
        imgs = (CircleImageView) findViewById(R.id.civ);

        name = (TextView) findViewById(R.id.name);

        //手机号
        phone = (TextView) findViewById(R.id.pa_tv_phone);
        phone.setText("");
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String userphotos = intent.getStringExtra("userphotos");
        String phone = intent.getStringExtra("phone");
        Glide.with(PersinalInfoActivity.this).load(userphotos).into(imgs);
        name.setText(username);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_persinal_info;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pa_rl:
                Intent intent = new Intent(PersinalInfoActivity.this, NameActivity.class);
                startActivityForResult(intent, 10086);
                break;
            case R.id.rl_weichat:
                Intent intent1 = new Intent(PersinalInfoActivity.this, WeiChatActivity.class);
                startActivity(intent1);
                break;
            case R.id.rl_con_add:
                Intent intent7 = new Intent(PersinalInfoActivity.this, ConAddActivity.class);
                startActivity(intent7);
                break;
            case R.id.rl_qq:
                Intent intent2 = new Intent(PersinalInfoActivity.this, QQActivity.class);
                startActivity(intent2);
                break;
            case R.id.rl_data:
                popupWindow = new PopupWindow(calendar, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                popupWindow.setFocusable(true);
                ColorDrawable dw2 = new ColorDrawable(0xb0000000);
                // 设置弹出窗体的背景
                popupWindow.setBackgroundDrawable(dw2);
                popupWindow.showAtLocation(calendar, Gravity.BOTTOM, 0, 0);

                mStartDateButton = (Button) calendar.findViewById(R.id.start_date_btn);
                mEndDateButton = (Button) calendar.findViewById(R.id.end_date_btn);
                mDateValidButton = (Button) calendar.findViewById(R.id.date_valid_btn);
                mShowContentTextView = (TextView) calendar.findViewById(R.id.show_content_tv);

                mStartDateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DateChooseWheelViewDialog startDateChooseDialog = new DateChooseWheelViewDialog(PersinalInfoActivity.this, new DateChooseWheelViewDialog.DateChooseInterface() {
                            @Override
                            public void getDateTime(String time, boolean longTimeChecked) {
                                mShowContentTextView.setText(time);
                            }
                        });
                        startDateChooseDialog.setDateDialogTitle("开始时间");
                        startDateChooseDialog.showDateChooseDialog();
                    }
                });


                mEndDateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(PersinalInfoActivity.this,
                                new DateChooseWheelViewDialog.DateChooseInterface() {
                                    @Override
                                    public void getDateTime(String time, boolean longTimeChecked) {
                                        mShowContentTextView.setText(time);
                                    }
                                });
                        endDateChooseDialog.setTimePickerGone(true);
                        endDateChooseDialog.setDateDialogTitle("结束时间");
                        endDateChooseDialog.showDateChooseDialog();
                    }
                });


                break;
            case R.id.rl_sex:
                popupWindow = new PopupWindow(sex, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                TextView nan = sex.findViewById(R.id.tv_nan);
                final String trimnan = nan.getText().toString().trim();
                nan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_sex.setText(trimnan);
                    }
                });
                TextView nv = sex.findViewById(R.id.tv_nv);
                final String trimnv = nv.getText().toString().trim();
                nv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_sex.setText(trimnv);
                    }
                });
                popupWindow.setFocusable(true);
                ColorDrawable dw1 = new ColorDrawable(0xb0000000);
                // 设置弹出窗体的背景
                popupWindow.setBackgroundDrawable(dw1);
                popupWindow.showAtLocation(sex, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.header_icon:
                popupWindow = new PopupWindow(Mypup, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                popupWindow.setFocusable(true);
                ColorDrawable dw = new ColorDrawable(0xb0000000);
                // 设置弹出窗体的背景
                popupWindow.setBackgroundDrawable(dw);
                popupWindow.showAtLocation(Mypup, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.phono_Album:
                //从相册获取头像
                autoObtainStoragePermission();
                break;
            case R.id.take_photo:
                //用相机拍一张
                autoObtainCameraPermission();
                break;
            case R.id.bt_cancel:
                popupWindow.dismiss();
                break;

        }

    }


    /**
     * 自动获取相机权限
     */
    private void autoObtainCameraPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtils.showShort(this, "您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    imageUri = FileProvider.getUriForFile(PersinalInfoActivity.this, "com.zz.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case CAMERA_PERMISSIONS_REQUEST_CODE: {//调用系统相机申请拍照权限回调
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            imageUri = FileProvider.getUriForFile(PersinalInfoActivity.this, "com.zz.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                        PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                } else {

                    ToastUtils.showShort(this, "请允许打开相机！！");
                }
                break;


            }
            case STORAGE_PERMISSIONS_REQUEST_CODE://调用系统相册申请Sdcard权限回调
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
                } else {

                    ToastUtils.showShort(this, "请允许打操作SDCard！！");
                }
                break;
        }
    }

    private int output_X = 480;
    private int output_Y = 480;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
/*
        if (requestCode == 10086 && requestCode == 200) {
            String name = data.getStringExtra("name");
            this.name.setText(name);
            updateName(name);
        }*/


        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_CAMERA_REQUEST://拍照完成回调
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);
                    break;
                case CODE_GALLERY_REQUEST://访问相册完成回调
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            newUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", new File(newUri.getPath()));
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
            }

        }
//        if(requestCode==1){
//              String name=data.getStringExtra("name");
//              show(name);
//        }
    }


    /**
     * 自动获取sdk权限
     */

    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }

    }

    private void showImages(Bitmap bitmap) {
        //往控件上设置图片的
        imgs.setImageBitmap(bitmap);

        //上传头像
        uploadPic(bitmap);
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }


    //上传头像到服务器
    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了

        //保存头像
        String imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath + "");
        if (imagePath != null) {
            // 拿着imagePath上传了

            okhttp();
        }
    }

    private void okhttp() {
        String userId = UserManager.getIntance().getUserId();

        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        String json = CJSON.toJSONMap(map);
        FormBody.Builder body = new FormBody.Builder();
        body.add(CJSON.DATA, json);
        Request request = new Request.Builder().url(CJSON.URL_STRING + "user/getUserInfoByVO.jhtml")
                .post(body.build())
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String str = response.body().string();


                Log.e("TAG", str);

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(str);
                    final boolean ret = jsonObject.getBoolean("ret");
                    JSONObject jsonObject1 = jsonObject.getJSONObject("result");
                    final String userId = jsonObject1.getString("userId");
                    Log.e("TAG", "ID----------" + userId);
                    final long userPhone = jsonObject1.getLong("userPhone");
                    final String userName = jsonObject1.getString("userName");
                    App.baseActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (ret) {
                                showToast("上传成功");

                            } else {
                                showToast("上传失败");
                            }
                        }
                    });
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }
//         public void  show(String string,){
//             OkHttpClient okHttpClient=new OkHttpClient();
//              Map<String,Object> map=new HashMap<>();
//               map.put("",string);
//             String json=CJSON.toJSONMap(map);
//             FormBody.Builder  body=new FormBody.Builder();
//              body.add(CJSON.DATA,json);
//             Request request=new Request.Builder().url(CJSON.URL_STRING+"").post(body.build()).build();
//             okHttpClient.newCall(request).enqueue(new Callback() {
//                 @Override
//                 public void onFailure(Call call, IOException e) {
//
//                 }
//
//                 @Override
//                 public void onResponse(Call call, Response response) throws IOException {
//
//                 }
//             });
//         }


    private void updateName(final String name) {


        Map<String, Object> param = new HashMap<>();
        param.put(TableUtils.UserInfo.USERID, UserManager.getIntance().getUserId());
        param.put(TableUtils.UserInfo.USERNAME, name);
        // 生成提交服务器的JSON字符串
        String json = CJSON.toJSONMap(param);
        // FileUtil.getToken();


        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add(CJSON.DATA, json);
        builder.build();

        final Request request = new Request.Builder().post(builder.build()).url(AppUtils.REQUESTURL + "user/updateUserInfo.jhtml").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure: ", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (CJSON.getRET(string)) {
                            AppUtils.userInfo.setUserName(name);

//                            UserInfo userInfo = new UserInfo();
//                            userInfo.setUserName("");
//                            userInfo.setUserName(etUpdataName.getText().toString());
//                            UserManager.getIntance().saveUser(userInfo);

                            FileUtil.saveUser(AppUtils.userInfo);
                            ToastUtil.show("修改成功!");
                          /*  Intent intent = new Intent(NameActivity.this, PersinalInfoActivity.class);
                            startActivity(intent);*/
//                            finish();
                        } else {
                            ToastUtil.show("修改失败");
                        }
                    }
                });

            }
        });


    }
}


