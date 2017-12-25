package jiyun.com.lovepet.bean;

import java.util.List;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class JiYangShiBean  {
    /**
     * ret : true
     * desc : {"fosterImages":[{"usersId":"b10d158ea94f4489a9100ce61bb611c4","id":537,"imageUrl":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084407.png"},{"usersId":"b10d158ea94f4489a9100ce61bb611c4","id":538,"imageUrl":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084314.png"},{"usersId":"b10d158ea94f4489a9100ce61bb611c4","id":539,"imageUrl":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084256.png"}],"fosterServices":[{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"大型犬","id":0,"isRe":0,"petPrice":"10.00","typeCode":"23c8d60ef10644ee96314c11c4d3f86b"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"中型犬","id":0,"isRe":0,"petPrice":"10.00","typeCode":"fe013d906bae4945a468780a94212ff7"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小型犬","id":0,"isRe":0,"petPrice":"20.00","typeCode":"20706e878a7b4625be0c5460371a6c25"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"猫","id":0,"isRe":0,"petPrice":"10.00","typeCode":"2aa312a64be44067a4eee43b94c1f9b8"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小宠","id":0,"isRe":0,"petPrice":"30.00","typeCode":"ffd1209b320c4bb382c5bdac4f722cf4"}],"fosterInfo":{"businessLicense":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084250.png","isUse":0,"coordX":"30.543494","coordY":"117.063755","userPhone":18410078798,"cityId":"安庆市","intro":"你好啊","id":0,"state":3,"qq":0,"userSex":1,"address":"安徽省安庆市","identify":"278","openEndTime":"2016-06-17 00:00:00.0","identityCard":"130821199404092710","userName":"11","userId":"b10d158ea94f4489a9100ce61bb611c4","realName":"任梓华","identityImage":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084223.png","position":2,"family":"狗狗","openBeginTime":"2016-05-10 00:00:00.0"},"fosterOtherServices":[{"isUse":0,"serviceCode":"3444cf2558df436c87ef4b3fb15c621e","servicePicture":"bathe.png","petTypeCode":"23c8d60ef10644ee96314c11c4d3f86b","serviceName":"洗澡1","unit":"元/次","isStandard":0,"petTypeName":"大型犬","servicePrice":"10.00","id":0},{"isUse":0,"serviceCode":"228973a1c817412e9cd01ea1d2beb12d","servicePicture":"bathe.png","petTypeCode":"fe013d906bae4945a468780a94212ff7","serviceName":"洗澡2","unit":"元/次","isStandard":0,"petTypeName":"中型犬","servicePrice":"30.00","id":0},{"isUse":0,"serviceCode":"fbd1cf13ce5641b8b97444695740c5c6","servicePicture":"bathe.png","petTypeCode":"20706e878a7b4625be0c5460371a6c25","serviceName":"洗澡3","unit":"元/次","isStandard":0,"petTypeName":"小型犬","servicePrice":"20.00","id":0},{"isUse":0,"serviceCode":"04c5a71b27674e51a296d2684ae02d50","servicePicture":"bathe.png","petTypeCode":"2aa312a64be44067a4eee43b94c1f9b8","serviceName":"洗澡4","unit":"元/次","isStandard":0,"petTypeName":"猫","servicePrice":"40.00","id":0},{"isUse":0,"serviceCode":"db9aeac40da94985bc2581bd1ea09eb6","servicePicture":"bathe.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"洗澡5","unit":"元/次","isStandard":0,"petTypeName":"小宠","servicePrice":"100.00","id":0},{"isUse":0,"serviceCode":"d03a5e0f8845406c9477bd6f7a1ced4c","servicePicture":"shuttle.png","petTypeCode":"2aa312a64be44067a4eee43b94c1f9b8","serviceName":"接送3","unit":"元/公里","isStandard":0,"petTypeName":"猫","servicePrice":"45.00","id":0},{"isUse":0,"serviceCode":"2bd0c64bb2784f7f9e85d806a10f8644","servicePicture":"shuttle.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"接送4","unit":"元/公里","isStandard":0,"petTypeName":"小宠","servicePrice":"23.00","id":0}]}
     */

    private boolean ret;
    private DescBean desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public DescBean getDesc() {
        return desc;
    }

    public void setDesc(DescBean desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * fosterImages : [{"usersId":"b10d158ea94f4489a9100ce61bb611c4","id":537,"imageUrl":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084407.png"},{"usersId":"b10d158ea94f4489a9100ce61bb611c4","id":538,"imageUrl":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084314.png"},{"usersId":"b10d158ea94f4489a9100ce61bb611c4","id":539,"imageUrl":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084256.png"}]
         * fosterServices : [{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"大型犬","id":0,"isRe":0,"petPrice":"10.00","typeCode":"23c8d60ef10644ee96314c11c4d3f86b"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"中型犬","id":0,"isRe":0,"petPrice":"10.00","typeCode":"fe013d906bae4945a468780a94212ff7"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小型犬","id":0,"isRe":0,"petPrice":"20.00","typeCode":"20706e878a7b4625be0c5460371a6c25"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"猫","id":0,"isRe":0,"petPrice":"10.00","typeCode":"2aa312a64be44067a4eee43b94c1f9b8"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小宠","id":0,"isRe":0,"petPrice":"30.00","typeCode":"ffd1209b320c4bb382c5bdac4f722cf4"}]
         * fosterInfo : {"businessLicense":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084250.png","isUse":0,"coordX":"30.543494","coordY":"117.063755","userPhone":18410078798,"cityId":"安庆市","intro":"你好啊","id":0,"state":3,"qq":0,"userSex":1,"address":"安徽省安庆市","identify":"278","openEndTime":"2016-06-17 00:00:00.0","identityCard":"130821199404092710","userName":"11","userId":"b10d158ea94f4489a9100ce61bb611c4","realName":"任梓华","identityImage":"/b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084223.png","position":2,"family":"狗狗","openBeginTime":"2016-05-10 00:00:00.0"}
         * fosterOtherServices : [{"isUse":0,"serviceCode":"3444cf2558df436c87ef4b3fb15c621e","servicePicture":"bathe.png","petTypeCode":"23c8d60ef10644ee96314c11c4d3f86b","serviceName":"洗澡1","unit":"元/次","isStandard":0,"petTypeName":"大型犬","servicePrice":"10.00","id":0},{"isUse":0,"serviceCode":"228973a1c817412e9cd01ea1d2beb12d","servicePicture":"bathe.png","petTypeCode":"fe013d906bae4945a468780a94212ff7","serviceName":"洗澡2","unit":"元/次","isStandard":0,"petTypeName":"中型犬","servicePrice":"30.00","id":0},{"isUse":0,"serviceCode":"fbd1cf13ce5641b8b97444695740c5c6","servicePicture":"bathe.png","petTypeCode":"20706e878a7b4625be0c5460371a6c25","serviceName":"洗澡3","unit":"元/次","isStandard":0,"petTypeName":"小型犬","servicePrice":"20.00","id":0},{"isUse":0,"serviceCode":"04c5a71b27674e51a296d2684ae02d50","servicePicture":"bathe.png","petTypeCode":"2aa312a64be44067a4eee43b94c1f9b8","serviceName":"洗澡4","unit":"元/次","isStandard":0,"petTypeName":"猫","servicePrice":"40.00","id":0},{"isUse":0,"serviceCode":"db9aeac40da94985bc2581bd1ea09eb6","servicePicture":"bathe.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"洗澡5","unit":"元/次","isStandard":0,"petTypeName":"小宠","servicePrice":"100.00","id":0},{"isUse":0,"serviceCode":"d03a5e0f8845406c9477bd6f7a1ced4c","servicePicture":"shuttle.png","petTypeCode":"2aa312a64be44067a4eee43b94c1f9b8","serviceName":"接送3","unit":"元/公里","isStandard":0,"petTypeName":"猫","servicePrice":"45.00","id":0},{"isUse":0,"serviceCode":"2bd0c64bb2784f7f9e85d806a10f8644","servicePicture":"shuttle.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"接送4","unit":"元/公里","isStandard":0,"petTypeName":"小宠","servicePrice":"23.00","id":0}]
         */

        private FosterInfoBean fosterInfo;
        private List<FosterImagesBean> fosterImages;
        private List<FosterServicesBean> fosterServices;
        private List<FosterOtherServicesBean> fosterOtherServices;

        public FosterInfoBean getFosterInfo() {
            return fosterInfo;
        }

        public void setFosterInfo(FosterInfoBean fosterInfo) {
            this.fosterInfo = fosterInfo;
        }

        public List<FosterImagesBean> getFosterImages() {
            return fosterImages;
        }

        public void setFosterImages(List<FosterImagesBean> fosterImages) {
            this.fosterImages = fosterImages;
        }

        public List<FosterServicesBean> getFosterServices() {
            return fosterServices;
        }

        public void setFosterServices(List<FosterServicesBean> fosterServices) {
            this.fosterServices = fosterServices;
        }

        public List<FosterOtherServicesBean> getFosterOtherServices() {
            return fosterOtherServices;
        }

        public void setFosterOtherServices(List<FosterOtherServicesBean> fosterOtherServices) {
            this.fosterOtherServices = fosterOtherServices;
        }

        public static class FosterInfoBean {
            /**
             * businessLicense : /b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084250.png
             * isUse : 0
             * coordX : 30.543494
             * coordY : 117.063755
             * userPhone : 18410078798
             * cityId : 安庆市
             * intro : 你好啊
             * id : 0
             * state : 3
             * qq : 0
             * userSex : 1
             * address : 安徽省安庆市
             * identify : 278
             * openEndTime : 2016-06-17 00:00:00.0
             * identityCard : 130821199404092710
             * userName : 11
             * userId : b10d158ea94f4489a9100ce61bb611c4
             * realName : 任梓华
             * identityImage : /b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084223.png
             * position : 2
             * family : 狗狗
             * openBeginTime : 2016-05-10 00:00:00.0
             */

            private String businessLicense;
            private int isUse;
            private String coordX;
            private String coordY;
            private long userPhone;
            private String cityId;
            private String intro;
            private int id;
            private int state;
            private int qq;
            private int userSex;
            private String address;
            private String identify;
            private String openEndTime;
            private String identityCard;
            private String userName;
            private String userId;
            private String realName;
            private String identityImage;
            private int position;
            private String family;
            private String openBeginTime;

            public String getBusinessLicense() {
                return businessLicense;
            }

            public void setBusinessLicense(String businessLicense) {
                this.businessLicense = businessLicense;
            }

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getCoordX() {
                return coordX;
            }

            public void setCoordX(String coordX) {
                this.coordX = coordX;
            }

            public String getCoordY() {
                return coordY;
            }

            public void setCoordY(String coordY) {
                this.coordY = coordY;
            }

            public long getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(long userPhone) {
                this.userPhone = userPhone;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getQq() {
                return qq;
            }

            public void setQq(int qq) {
                this.qq = qq;
            }

            public int getUserSex() {
                return userSex;
            }

            public void setUserSex(int userSex) {
                this.userSex = userSex;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getIdentify() {
                return identify;
            }

            public void setIdentify(String identify) {
                this.identify = identify;
            }

            public String getOpenEndTime() {
                return openEndTime;
            }

            public void setOpenEndTime(String openEndTime) {
                this.openEndTime = openEndTime;
            }

            public String getIdentityCard() {
                return identityCard;
            }

            public void setIdentityCard(String identityCard) {
                this.identityCard = identityCard;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getIdentityImage() {
                return identityImage;
            }

            public void setIdentityImage(String identityImage) {
                this.identityImage = identityImage;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public String getFamily() {
                return family;
            }

            public void setFamily(String family) {
                this.family = family;
            }

            public String getOpenBeginTime() {
                return openBeginTime;
            }

            public void setOpenBeginTime(String openBeginTime) {
                this.openBeginTime = openBeginTime;
            }
        }

        public static class FosterImagesBean {
            /**
             * usersId : b10d158ea94f4489a9100ce61bb611c4
             * id : 537
             * imageUrl : /b10d158ea94f4489a9100ce61bb611c4/IMG_20160518_084407.png
             */

            private String usersId;
            private int id;
            private String imageUrl;

            public String getUsersId() {
                return usersId;
            }

            public void setUsersId(String usersId) {
                this.usersId = usersId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }

        public static class FosterServicesBean {
            /**
             * isUse : 0
             * parentTypeName :
             * petTypeImage : cat.png
             * parentTypeCode :
             * typeName : 大型犬
             * id : 0
             * isRe : 0
             * petPrice : 10.00
             * typeCode : 23c8d60ef10644ee96314c11c4d3f86b
             */

            private int isUse;
            private String parentTypeName;
            private String petTypeImage;
            private String parentTypeCode;
            private String typeName;
            private int id;
            private int isRe;
            private String petPrice;
            private String typeCode;

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getParentTypeName() {
                return parentTypeName;
            }

            public void setParentTypeName(String parentTypeName) {
                this.parentTypeName = parentTypeName;
            }

            public String getPetTypeImage() {
                return petTypeImage;
            }

            public void setPetTypeImage(String petTypeImage) {
                this.petTypeImage = petTypeImage;
            }

            public String getParentTypeCode() {
                return parentTypeCode;
            }

            public void setParentTypeCode(String parentTypeCode) {
                this.parentTypeCode = parentTypeCode;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsRe() {
                return isRe;
            }

            public void setIsRe(int isRe) {
                this.isRe = isRe;
            }

            public String getPetPrice() {
                return petPrice;
            }

            public void setPetPrice(String petPrice) {
                this.petPrice = petPrice;
            }

            public String getTypeCode() {
                return typeCode;
            }

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }
        }

        public static class FosterOtherServicesBean{
            /**
             * isUse : 0
             * serviceCode : 3444cf2558df436c87ef4b3fb15c621e
             * servicePicture : bathe.png
             * petTypeCode : 23c8d60ef10644ee96314c11c4d3f86b
             * serviceName : 洗澡1
             * unit : 元/次
             * isStandard : 0
             * petTypeName : 大型犬
             * servicePrice : 10.00
             * id : 0
             */

            private int isUse;
            private String serviceCode;
            private String servicePicture;
            private String petTypeCode;
            private String serviceName;
            private String unit;
            private int isStandard;
            private String petTypeName;
            private String servicePrice;
            private int id;

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getServiceCode() {
                return serviceCode;
            }

            public void setServiceCode(String serviceCode) {
                this.serviceCode = serviceCode;
            }

            public String getServicePicture() {
                return servicePicture;
            }

            public void setServicePicture(String servicePicture) {
                this.servicePicture = servicePicture;
            }

            public String getPetTypeCode() {
                return petTypeCode;
            }

            public void setPetTypeCode(String petTypeCode) {
                this.petTypeCode = petTypeCode;
            }

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getIsStandard() {
                return isStandard;
            }

            public void setIsStandard(int isStandard) {
                this.isStandard = isStandard;
            }

            public String getPetTypeName() {
                return petTypeName;
            }

            public void setPetTypeName(String petTypeName) {
                this.petTypeName = petTypeName;
            }

            public String getServicePrice() {
                return servicePrice;
            }

            public void setServicePrice(String servicePrice) {
                this.servicePrice = servicePrice;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
