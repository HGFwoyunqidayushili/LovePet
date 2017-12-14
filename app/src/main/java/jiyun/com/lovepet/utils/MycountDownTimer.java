package jiyun.com.lovepet.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by 阿三 on 2017/12/13.
 */
public class MycountDownTimer extends CountDownTimer {
    private TextView textView;
    public MycountDownTimer(long millisInFuture, long countDownInterval, TextView tv_yanzhengma) {
        super(millisInFuture, countDownInterval);
        this.textView=tv_yanzhengma;
    }

    @Override
    public void onTick(long l) {
        textView.setText((l/1000)+"S后重新获取");
        textView.setClickable(false);
    }
    @Override
    public void onFinish() {
        textView.setText("重新获取");
        textView.setClickable(true);
    }
}
