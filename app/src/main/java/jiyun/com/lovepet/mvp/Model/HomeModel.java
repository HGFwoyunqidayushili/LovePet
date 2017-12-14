package jiyun.com.lovepet.mvp.Model;

import java.util.ArrayList;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class HomeModel implements InfHomeModel {
    @Override
    public void setDatafromPresenter(Callbacks callbacks) {
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("小型犬");
        strings1.add("中型犬");
        strings1.add("大型犬");
        strings1.add("猫");
        strings1.add("小宠");
        strings1.add("幼犬");
        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("好评优先");
        strings2.add("附近优先");
        strings2.add("订单优先");
        strings2.add("价格从低到高");
        strings2.add("价格从高到底");
          callbacks.setData(strings1,strings2);
    }
}
