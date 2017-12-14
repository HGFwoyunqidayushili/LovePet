package jiyun.com.lovepet.entity.user;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by 阿三 on 2017/12/11.
 * //用户的实体类信息
 */
public class UserInfo implements Serializable{
   private String UserId;  //用户的id
   private String UserName; //用户名称
   private String UserSex;  //用户性别
   private Date UserData;   //用户出生日期
   private String UserPhone;  //用户手机号
   private String address;    //用户地址
   private String UserImgage;   //用户头像
   private String UserPassword; //用户密码


    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userIdl) {
        UserId = userIdl;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public Date getUserData() {
        return UserData;
    }

    public void setUserData(Date userData) {
        UserData = userData;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserImgage() {
        return UserImgage;
    }

    public void setUserImgage(String userImgage) {
        UserImgage = userImgage;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "UserId='" + UserId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserSex='" + UserSex + '\'' +
                ", UserData=" + UserData +
                ", UserPhone='" + UserPhone + '\'' +
                ", address='" + address + '\'' +
                ", UserImgage='" + UserImgage + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                '}';
    }
}
