package jiyun.com.lovepet.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DELL zhanghuirong on 2017/12/19.
 */

public class ToastUtils {
    public static void showShort(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
