package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CustomTextLayout;
import jiyun.com.lovepet.utils.ImageUtils;

public class AddPetActivity extends BaseActivity implements View.OnClickListener {

    private PopupWindow popupWindow;

    private View Mypup;
    private TextView phono_Album;
    private TextView take_photo;
    private Button dismiss;
    private CustomTextLayout App_title;
    private RelativeLayout pet_icon;
    private RelativeLayout pet_name;
    private RelativeLayout pet_kind;
    private RelativeLayout sterilization;
    private RelativeLayout pet_Dateofbirth;
    private RelativeLayout pet_weight;
    private RelativeLayout pet_sick;
    private EditText pet_info;
    private ImageView imageView;
    private View sexpup;
    /* 请求识别码 */
    private static final int CODE_GALLERY_REQUEST = 0;
    private static final int CODE_CAMERA_REQUEST = 1;
    private static final int CODE_RESULT_REQUEST = 2;
    //是否绝育
     private boolean issterilization=false;
    private TextView mTV_pet_name,mTV_pet_kind,mTV_pet_sterilization,mTV_pet_birthDate,mTV_pet_WeigthEE,mTV_pet_Immune;
    private String petDate;

    @Override
    protected void initView() {
        Mypup = LayoutInflater.from(this).inflate(R.layout.popupwindow, null);
        sexpup=LayoutInflater.from(this).inflate(R.layout.sexpopupwindow,null);
        mTV_pet_name= (TextView) findViewById(R.id.mTV_pet_name);
        mTV_pet_kind= (TextView) findViewById(R.id.mTV_pet_kind);
        mTV_pet_sterilization= (TextView) findViewById(R.id.mTV_pet_sterilization);
        mTV_pet_birthDate= (TextView) findViewById(R.id.mTV_pet_birthDate);
        mTV_pet_WeigthEE= (TextView) findViewById(R.id.mTV_pet_WeigthEE);
        mTV_pet_Immune= (TextView) findViewById(R.id.mTV_pet_Immune);

        //相册

        phono_Album = (TextView) Mypup.findViewById(R.id.phono_Album);
        take_photo = (TextView) Mypup.findViewById(R.id.take_photo);
        dismiss = (Button) Mypup.findViewById(R.id.bt_cancel);
        phono_Album.setOnClickListener(this);
        take_photo.setOnClickListener(this);
        dismiss.setOnClickListener(this);


        App_title = (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("添加宠物", "#353535");
        App_title.setRightTv("保存", "#353535");
        pet_icon = (RelativeLayout) findViewById(R.id.pet_icon);
        pet_name = (RelativeLayout) findViewById(R.id.pet_name);
        pet_kind = (RelativeLayout) findViewById(R.id.pet_kind);
        sterilization = (RelativeLayout) findViewById(R.id.sterilization);
        pet_Dateofbirth = (RelativeLayout) findViewById(R.id.pet_Dateofbirth);
        pet_weight = (RelativeLayout) findViewById(R.id.pet_weight);
        pet_sick = (RelativeLayout) findViewById(R.id.pet_sick);
        pet_info = (EditText) findViewById(R.id.pet_info);
        imageView= (ImageView) findViewById(R.id.img);
        pet_icon.setOnClickListener(this);
        pet_name.setOnClickListener(this);
        pet_kind.setOnClickListener(this);
        sterilization.setOnClickListener(this);
        pet_Dateofbirth.setOnClickListener(this);
        pet_weight.setOnClickListener(this);
        pet_sick.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_pet;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.pet_icon:
                popupWindow = new PopupWindow(Mypup, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                popupWindow.setFocusable(true);
                ColorDrawable dw = new ColorDrawable(0xb0000000);
                // 设置弹出窗体的背景
                popupWindow.setBackgroundDrawable(dw);
                popupWindow.showAtLocation(Mypup, Gravity.BOTTOM, 0, 0);
                break;

            case R.id.pet_name:
                intent=new Intent(this,NickNameActivity.class);
                startActivityForResult(intent,3);
                break;

            case R.id.pet_kind:
                intent=new Intent(this,PetkindActivity.class);
                startActivity(intent);
                break;
            case R.id.sterilization:
                //是否绝育
               addisSterilization();
                break;
            case R.id.pet_Dateofbirth:
                showToast("黄国峰");
                SeclectorDateActivity.startActivity(this, "选择日期",
                        new SeclectorDateActivity.OnGetDateListener() {
                            @Override
                            public void dateChange(String date) {
                                petDate = date;
                                mTV_pet_birthDate.setText(petDate);
                            }
                        });
                break;
            case R.id.pet_weight:
                add_pet_weight();
                break;
            case R.id.pet_sick:
                break;
            case R.id.phono_Album:
                Intent intentFromGallery = new Intent(Intent.ACTION_PICK, null);
                // 设置文件类型
                intentFromGallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
                break;
            case R.id.take_photo:
                Intent intent1 = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                //下面这句指定调用相机拍照后的照片存储的路径
                intent1.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                        .fromFile(new File(Environment
                                .getExternalStorageDirectory(),
                                "Love_pet.jpg")));
                startActivityForResult(intent1, CODE_CAMERA_REQUEST);
                break;
            case R.id.bt_cancel:
                popupWindow.dismiss();
                break;

        }
    }
    /*
       添加体重
     */
    private void add_pet_weight() {

    }

    /*
       是否绝育
     */
    private void addisSterilization() {
       popupWindow = new PopupWindow(sexpup, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        popupWindow.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.showAtLocation(Mypup, Gravity.BOTTOM, 0, 0);
        TextView yes= (TextView) sexpup.findViewById(R.id.yes);
        TextView no= (TextView) sexpup.findViewById(R.id.no);
          yes.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  issterilization=true;
                  mTV_pet_sterilization.setText("是");
                 popupWindow.dismiss();
              }
          });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                issterilization=false;
                mTV_pet_sterilization.setText("否");
                popupWindow.dismiss();
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case CODE_GALLERY_REQUEST:
                    // 开始对图片进行裁剪处理  //从相册中获取
                    startPhotoZoom(data.getData());

                    break;
                case CODE_CAMERA_REQUEST:
                    File temp = new File(Environment.getExternalStorageDirectory()
                            + "/xiaoma.jpg");

                    startPhotoZoom(Uri.fromFile(temp));

                    break;
                case CODE_RESULT_REQUEST:
                    if (data != null) {
                        // 让刚才选择裁剪得到的图片显示在界面上
                        setPicToView(data);
                        Toast.makeText(AddPetActivity.this, "214142", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
        if(requestCode==3&&resultCode==RESULT_OK){
              String name=data.getStringExtra("name");
              mTV_pet_name.setText(name);
        }
    }

    private void startPhotoZoom(Uri data) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(data, "image/*");

        //下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    private void setPicToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            //图片路径
            Bitmap bitmap = ImageUtils.toRoundBitmap(photo);
            imageView.setImageBitmap(bitmap);


        }
    }


}
