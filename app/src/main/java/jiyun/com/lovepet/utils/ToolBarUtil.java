package jiyun.com.lovepet.utils;

import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DELL zhanghuirong on 2017/12/22.
 */

public class ToolBarUtil {
    public static void setTitle(TextView rvTitle, String string, TextView rvRegistered, String st) {
        rvTitle.setText(string);
        rvTitle.setTextSize(18);
        rvTitle.setTextColor(Color.BLACK);

        rvRegistered.setText(st);
        rvRegistered.setTextSize(13);
        rvRegistered.setTextColor(Color.BLACK);
    }

    public static void hint(EditText etUpdataName, String string) {
        etUpdataName.setHint(string);
    }
}
