package jiyun.com.lovepet.qq.bean;

/**
 * Created by DELL zhanghuirong on 2017/12/21.
 */

public class ZhuCe {

    /**
     * ret : true
     * result : {"position":0,"isUse":0,"identityCard":0,"password":"E10ADC3949BA59ABBE56E057F20F883E","id":0,"threeId":"047BED954FA552DF330E2813B86ED531","userId":"be090d12e8d544d2b5d37a3678cb92ff","userSex":0,"userName":"琉夏","userPhone":18612187602,"qq":0}
     */

    private boolean ret;
    private ResultBean result;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * position : 0
         * isUse : 0
         * identityCard : 0
         * password : E10ADC3949BA59ABBE56E057F20F883E
         * id : 0
         * threeId : 047BED954FA552DF330E2813B86ED531
         * userId : be090d12e8d544d2b5d37a3678cb92ff
         * userSex : 0
         * userName : 琉夏
         * userPhone : 18612187602
         * qq : 0
         */

        private int position;
        private int isUse;
        private int identityCard;
        private String password;
        private int id;
        private String threeId;
        private String userId;
        private int userSex;
        private String userName;
        private long userPhone;
        private int qq;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getIsUse() {
            return isUse;
        }

        public void setIsUse(int isUse) {
            this.isUse = isUse;
        }

        public int getIdentityCard() {
            return identityCard;
        }

        public void setIdentityCard(int identityCard) {
            this.identityCard = identityCard;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getThreeId() {
            return threeId;
        }

        public void setThreeId(String threeId) {
            this.threeId = threeId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public long getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(long userPhone) {
            this.userPhone = userPhone;
        }

        public int getQq() {
            return qq;
        }

        public void setQq(int qq) {
            this.qq = qq;
        }
    }
}
