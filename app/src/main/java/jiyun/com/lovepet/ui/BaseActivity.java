package jiyun.com.lovepet.ui;

import android.app.Dialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.utils.AppUtils;
import jiyun.com.lovepet.utils.ConnectionUtils;

public abstract class BaseActivity extends AppCompatActivity{
    private int dialog;
    private String string;
    private Dialog loadDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        App.baseActivity=this;
        ConnectionUtils.getIp(this);
        AppUtils.setAppContext(this);
        initView();
        initData(string);

    }

    protected abstract  void  initView();
    public abstract  void  initData(String str);
    protected abstract  int  getLayoutId();

    //正在加载的进度条
   public void showLoadingDialog(){
       dialog++;
       if(loadDialog!=null&&loadDialog.isShowing()){
           loadDialog.dismiss();
           loadDialog=null;
       }
      loadDialog=new Dialog(this,R.style.dialog);
      loadDialog.setContentView(R.layout.dialog);
       loadDialog.show();
   }
    //隐藏正在加载的进度条
     public void dismissLoadingDialog(){
         dialog--;
         if(dialog>0){
             return;
         }
         if(loadDialog!=null&&loadDialog.isShowing()){
             loadDialog.dismiss();
             loadDialog=null;
         }

     }
    public void showToast(String info){
        Toast.makeText(BaseActivity.this, info, Toast.LENGTH_SHORT).show();
    }

    /**
     * 判断手机是否有网络
     *
     * @return true 有网络
     */
    public boolean isConnected(){
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivity = (ConnectivityManager) this
                .getSystemService(this.CONNECTIVITY_SERVICE);
        if(connectivity!=null){
            // 获取网络连接管理的对象
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 判断当前网络是否已经连接
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }


        return false;
    }
}
