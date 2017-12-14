package jiyun.com.lovepet.mvp.presenter;

import android.content.Context;

import java.util.Map;

import jiyun.com.lovepet.mvp.Model.InfoModel;
import jiyun.com.lovepet.mvp.contract.Contract;

/**
 * Created by 阿三 on 2017/12/6.
 */
public class InfoPresenter implements Contract.Presenter {
     private Context context;
     private Contract.Model model;
     private Contract.Views views;

     public InfoPresenter(Contract.Views views, Context context){
     model=new InfoModel();


     this.views=views;
     this.context=context;

     }
    @Override
    public void getNewsData(String url) {
      model.requestNewsData(context,url,views);
    }

    @Override
    public void getPostData(String url, Map<String, String> map) {
        model.requestNewsDatas(context,url,map,views);
    }


}
