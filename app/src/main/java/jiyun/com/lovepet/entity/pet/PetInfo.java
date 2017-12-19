package jiyun.com.lovepet.entity.pet;

/**
 * Created by 阿三 on 2017/12/11.
 */
public class PetInfo {
    private String petImage; //宠物头像
    private String petName;   //宠物昵称
    private String petType;   //宠物类型
    private String brithDate;   //出生日期
    private double weigth;      //体重
    private String petInfo;       //宠物信息
    private int sterilization;    //是否绝育
    private  int Immune;          //是否免疫
    private String petTypename;    //宠物属性名字
    private String userName;
    private String userId;
    private String creatTime;

    @Override
    public String toString() {
        return "PetInfo{" +
                "petImage='" + petImage + '\'' +
                ", petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                ", brithDate='" + brithDate + '\'' +
                ", weigth='" + weigth + '\'' +
                ", petInfo='" + petInfo + '\'' +
                ", sterilization=" + sterilization +
                ", Immune=" + Immune +
                ", petTypename='" + petTypename + '\'' +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
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

    public String getPetTypename() {
        return petTypename;
    }

    public void setPetTypename(String petTypename) {
        this.petTypename = petTypename;
    }

    public String getPetImage() {
        return petImage;
    }

    public void setPetImage(String petImage) {
        this.petImage = petImage;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public String getPetInfo() {
        return petInfo;
    }

    public void setPetInfo(String petInfo) {
        this.petInfo = petInfo;
    }

    public int getSterilization() {
        return sterilization;
    }

    public void setSterilization(int sterilization) {
        this.sterilization = sterilization;
    }

    public int getImmune() {
        return Immune;
    }

    public void setImmune(int immune) {
        Immune = immune;
    }

}
