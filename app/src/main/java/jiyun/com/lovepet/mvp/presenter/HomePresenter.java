package jiyun.com.lovepet.mvp.presenter;

import java.util.ArrayList;

import jiyun.com.lovepet.mvp.Model.Callbacks;
import jiyun.com.lovepet.mvp.Model.HomeModel;
import jiyun.com.lovepet.mvp.Model.InfHomeModel;
import jiyun.com.lovepet.mvp.view.HomeView;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class HomePresenter {
    private InfHomeModel infHomeModel;
    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        infHomeModel =new HomeModel();
        this.homeView = homeView;
    }
    public void getgetDatatoView(){
        infHomeModel.setDatafromPresenter(new Callbacks() {
            @Override
            public void setData(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
                homeView.getData(arrayList,arrayList2);
            }
        });
    }
}
