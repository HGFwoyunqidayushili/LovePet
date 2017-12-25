package jiyun.com.lovepet.utils;

import android.Manifest.permission;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.imagepicker.ImagePicker;
import jiyun.com.lovepet.imagepicker.bean.ImageItem;
import jiyun.com.lovepet.imagepicker.ui.ImageCropActivity;
import jiyun.com.lovepet.imagepicker.ui.ImageGridActivity;

public class CutPhotoUtils extends Activity {

	private static final int IMAGE_PICKER = 2131231243;
	private static final int IMAGE_CROP = 2131765433;
	private static onGetCutPhotoCallBack mCallBack;
	private static String title;
	private static Activity mActivity;
	public static Bundle savedPhotoInstance;

	private TextView tvTitle;

	public static void start(Activity activity, onGetCutPhotoCallBack callBack) {
		mCallBack = callBack;
		mActivity = activity;
		mActivity.startActivity(new Intent(mActivity, CutPhotoUtils.class));
	}

	public static void setSelectCount(int count) {
		ImagePicker imagePicker = ImagePicker.getInstance();
		imagePicker.setSelectLimit(count); // 选中数量限制
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup_window_title_image);
		tvTitle = (TextView) findViewById(R.id.tvTitle);
		showDialog();
	}

	/**
	 * 
	 * @描述 :pop的标�?
	 * @方法名称 :setTitle---->CutPhotoActivity.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?4�?5�? 下午9:24:07
	 * @param txt
	 * 
	 */
	public static void setTitle(String txt) {
		title = txt;
	}

	private void showDialog() {
		if (!TextUtils.isEmpty(title)) {
			tvTitle.setText(title);
		}
		// 设置点击事件
		TextView tv_cancle = (TextView) findViewById(R.id.tv_cancle);
		tv_cancle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mCallBack.photoDatas(new ArrayList<ImageItem>());
				finish();
			}
		});
		TextView tv_album = (TextView) findViewById(R.id.tv_photograph);
		TextView tv_photo = (TextView) findViewById(R.id.tv_photo);
		tv_photo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (AppUtils
						.isCheckPermisstion(permission.WRITE_EXTERNAL_STORAGE)
						&& AppUtils
								.isCheckPermisstion(permission.READ_EXTERNAL_STORAGE)) {
					startActivityForResult(new Intent(CutPhotoUtils.this,
							ImageGridActivity.class).putExtra("isPicture",
							false), IMAGE_PICKER);
				} else {
					// ToastUtil.show("请赋予欢欢储存卡读写的权�?");
					Toast.makeText(CutPhotoUtils.this, "请赋予欢欢储存卡读写的权�?",
							Toast.LENGTH_LONG).show();
				}
			}
		});
		tv_album.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (AppUtils.isCheckPermisstion(permission.CAMERA)) {
					startActivityForResult(new Intent(CutPhotoUtils.this,
							ImageGridActivity.class)
							.putExtra("isPicture", true), IMAGE_CROP);
				} else {
					// ToastUtils.show("请赋予应用拍照的权限");
					Toast.makeText(CutPhotoUtils.this, "请赋予欢欢拍照权�?",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
			ArrayList<ImageItem> images = null;
			if (data != null && requestCode == IMAGE_PICKER) {
				images = (ArrayList<ImageItem>) data
						.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
				if (images.size() > 1) {
					mCallBack.photoDatas(images);
					finish();
				} else {
					startActivityForResult(new Intent(CutPhotoUtils.this,
							ImageCropActivity.class), IMAGE_CROP);
				}
			} else if (data != null && requestCode == IMAGE_CROP) {
				images = (ArrayList<ImageItem>) data
						.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
				mCallBack.photoDatas(images);
				finish();
			}
		} else if (resultCode == 0) {
			finish();
		}
	}

	public interface onGetCutPhotoCallBack {
		void photoDatas(List<ImageItem> item);
	}

}
