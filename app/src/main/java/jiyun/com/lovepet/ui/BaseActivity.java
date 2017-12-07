package jiyun.com.lovepet.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;

public abstract class BaseActivity extends AppCompatActivity{
    private int dialog;
    private Dialog loadDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.baseActivity=this;
        getLayoutId();
        initView();
        initData();

    }

    protected abstract  void  initView();
    protected abstract  void  initData();
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
}
