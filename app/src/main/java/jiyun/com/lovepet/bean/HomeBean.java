package jiyun.com.lovepet.bean;

import java.util.List;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class HomeBean   {

    /**
     * ret : true
     * desc : [{"score":3.6667,"address":"北京市昌平区沙河沙阳路18号北京科技职业学院","coordX":"40.11765","userImage":"http://q.qlogo.cn/qqapp/100371282/290BB8E0BEC8DF5989060A6947C3E75D/40","coordY":"116.250639","distance":129,"price":20,"orderCount":53,"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","family":"小街爆的家"},{"score":3.5,"address":"四平市 北京市昌平区沙河","coordX":"40.134235","userImage":"/d80488022f1e4278a3149f54beeac02a/IMG_20160509_140258.jpg","coordY":"116.280098","distance":3467,"price":10,"orderCount":28,"usersId":"d80488022f1e4278a3149f54beeac02a","family":"李丽丽了"},{"score":0,"address":"福建省.福州市.枞阳县","coordX":"40.0493","userImage":"http://q.qlogo.cn/qqapp/100371282/B368CC7246CC4A360C4305F64FE9173A/40","coordY":"116.296482","distance":8140,"price":30,"orderCount":2,"usersId":"6e710fd188b94d12bf12a6509ff3fe1f","family":"寄养998"},{"score":0,"address":"北京市  西城区","coordX":"39.912289","coordY":"116.365868","distance":23450,"price":10,"orderCount":0,"usersId":"43e2a6c8829245d488f90197e3c84b08","family":"昵称"},{"score":3.2222,"address":"北京昌平","coordX":"39.906898","userImage":"/f30e56db51d7ce93b3b58dbb16aea142/IMG_20160601_174725.png","coordY":"116.397238","distance":25583,"price":30,"orderCount":72,"usersId":"f30e56db51d7ce93b3b58dbb16aea142","family":"张三三"},{"score":0,"address":"北京市","coordX":"39.90403","coordY":"116.407526","distance":26417,"price":10,"orderCount":1,"usersId":"893cb45fa9ea4ffb8c9b28656f41a146","family":"zachay"},{"score":0,"address":"北京市","coordX":"39.90403","coordY":"116.407526","distance":26417,"price":10,"orderCount":1,"usersId":"fca3070783a94babaee37c52a52bb14a","family":"咿呀咿呀哟"},{"score":0,"address":"北京市城市\t北京市  海淀区\t城市\t北京市  昌平区","coordX":"39.92147","userImage":"http://q.qlogo.cn/qqapp/1105285855/862B29312F8D30591BEAC254DAFA551E/40","coordY":"116.443108","distance":27411,"price":30,"orderCount":0,"usersId":"a2ac592b1bdc4316a61054db23896f9a","family":"好放假了是的回复"},{"score":0,"address":"吕梁市汾阳市东关村牛王堂","coordX":"36.856329","userImage":"/63344fce512f449a988b1f330ee0e8db/IMG_20160424_162747.png","coordY":"114.494758","distance":370272,"price":40,"orderCount":2,"usersId":"63344fce512f449a988b1f330ee0e8db","family":"家家"},{"score":0,"address":"北京市九寨沟","coordX":"36.856329","userImage":"1","coordY":"114.494758","distance":370272,"orderCount":0,"usersId":"0e6a26bb351c4a818512c72d4b6bd7e5","family":"家家"},{"score":0,"address":"北京市朝阳\n","coordX":"41.573734","coordY":"120.450372","distance":444565,"price":20,"orderCount":1,"usersId":"06dc8e51c9444774a3f183d2243c4fb9","family":"hong\nhong"},{"score":0,"address":"安徽省安庆市","coordX":"30.543494","coordY":"117.063755","distance":960738,"price":10,"orderCount":0,"usersId":"b10d158ea94f4489a9100ce61bb611c4","family":"狗狗"},{"score":0,"address":"安徽省安庆市","coordX":"30.543494","userImage":"/9898fd90343b49ed82f71d10a084da28/IMG_20160517_114349.png","coordY":"117.063755","distance":960738,"price":10,"orderCount":0,"usersId":"9898fd90343b49ed82f71d10a084da28","family":"12321321"},{"score":0,"address":"安徽省安庆市","coordX":"30.543494","userImage":"http://192.168.26.185/dog_family/upload/e3974a2c49934b37b67e547ca6a0379f/IMG_20160518_154134.jpg","coordY":"117.063755","distance":960738,"price":10,"orderCount":0,"usersId":"e3974a2c49934b37b67e547ca6a0379f","family":"tungyuk"},{"score":0,"address":"安徽省安庆市","coordX":"30.543494","coordY":"117.063755","distance":960738,"price":30,"orderCount":0,"usersId":"8176d07f00424c0f950da7b2f913729d","family":"gaas"}]
     */

    private boolean ret;
    private List<DescBean> desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public List<DescBean> getDesc() {
        return desc;
    }

    public void setDesc(List<DescBean> desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * score : 3.6667
         * address : 北京市昌平区沙河沙阳路18号北京科技职业学院
         * coordX : 40.11765
         * userImage : http://q.qlogo.cn/qqapp/100371282/290BB8E0BEC8DF5989060A6947C3E75D/40
         * coordY : 116.250639
         * distance : 129
         * price : 20.0
         * orderCount : 53
         * usersId : 536e2c7b99204bbb81ad8fa7e6b2860f
         *
         *
         *
         * family : 小街爆的家
         */

        private double score;
        private String address;
        private String coordX;
        private String userImage;
        private String coordY;
        private int distance;
        private double price;
        private int orderCount;
        private String usersId;
        private String family;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCoordX() {
            return coordX;
        }

        public void setCoordX(String coordX) {
            this.coordX = coordX;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getCoordY() {
            return coordY;
        }

        public void setCoordY(String coordY) {
            this.coordY = coordY;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getUsersId() {
            return usersId;
        }

        public void setUsersId(String usersId) {
            this.usersId = usersId;
        }

        public String getFamily() {
            return family;
        }

        public void setFamily(String family) {
            this.family = family;
        }
    }
}
