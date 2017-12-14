package jiyun.com.lovepet.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 阿三 on 2017/12/11.
 */
public class SharePreferenceUtil {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharePreferenceUtil(Context context, String file) {
        sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        editor = sp.edit();
    }
}
