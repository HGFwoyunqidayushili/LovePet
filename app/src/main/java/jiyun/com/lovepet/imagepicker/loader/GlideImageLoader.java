package jiyun.com.lovepet.imagepicker.loader;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jiyun.com.lovepet.R;

public class GlideImageLoader implements ImageLoader {

	@Override
	public void displayImage(Activity activity, String path,
			ImageView imageView, int width, int height) {
		Glide.with(activity) // 配置上下文
				.load("file://" + path) // 设置图片路径
				.error(R.drawable.default_image) // 设置错误图片
				.placeholder(R.drawable.default_image) // 设置占位图片
				.diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存全尺寸
				.into(imageView);
	}

	@Override
	public void clearMemoryCache() {
	}
}
