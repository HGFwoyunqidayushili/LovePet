package jiyun.com.lovepet.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.pet.PetInfo;
import jiyun.com.lovepet.entity.user.UserInfo;
import jiyun.com.lovepet.utils.TokenUtil;

/**
 * Created by 阿三 on 2017/12/11.
 */
public class UserManager {

    private static UserManager userManager;
    public static UserInfo userInfo;
    public static PetInfo petInfo;
    private SharedPreferences sharedPreferences;

    public synchronized static UserManager getIntance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;

    }

    public UserManager() {
        sharedPreferences = App.getInstance().getSharedPreferences("user_info", Context.MODE_PRIVATE);

    }

    //保存当前用户
    public void saveUser(UserInfo bean) {
        if (bean == null) {
            return;
        }
        this.userInfo = bean;

        sharedPreferences.edit().putString("user", userInfo.toString()).commit();
        sharedPreferences.edit().putString("userId", userInfo.getUserId()).commit();
        Log.e("saveUser: ", bean.getUserId());
        sharedPreferences.edit().putString("usetName", userInfo.getUserName()).commit();
        sharedPreferences.edit().putInt("userState", userInfo.getState()).commit();
        sharedPreferences.edit().putLong("usetPhono", userInfo.getUserPhone()).commit();
        sharedPreferences.edit().putString("usetPhotos", userInfo.getUserImage()).commit();
//        sharedPreferences.edit().putString("usetPassWord", userInfo.getPassword()).commit();
    }

    public UserInfo getUserInfo() {

        return userInfo;
    }

    //用户是否登陆
    public boolean isLogin() {
        String userId = sharedPreferences.getString("userId", null);
        return !TextUtils.isEmpty(userId);
    }
//     public void saveLogin(){
//
//     }

    //清除用户信息
    public void clearUser() {
        userInfo = null;
        saveUser(userInfo);

    }

    //获取Token
    public void saveToken() {
        sharedPreferences.edit().putString("token", TokenUtil.createToken());
    }

    public String getToken() {
        String token = sharedPreferences.getString("token", null);
        return token;

    }

    //存储宠物信息
    public void savePetInfo(PetInfo petInfo) {
        sharedPreferences.edit().putString("petInfo", petInfo.toString());
        this.petInfo = petInfo;
    }

    public PetInfo getPetInfo() {
        if (userInfo.getUserId() == null) {
            return null;
        }
        return petInfo;
    }




    //获取id
    public String getUserId() {
        String id = sharedPreferences.getString("userId", null);
        Log.e("getUserId: ", id);
        return id;
    }

    //获取用户名
    public String getUserName() {
        String name = sharedPreferences.getString("usetName", null);
        return name;
    }

    //获取用户头像
    public String getUsetPhotos() {
        String usetPhotos = sharedPreferences.getString("usetPhotos", null);
        return usetPhotos;
    }
/*
    //获取用户密码
    public String getUsetPassWord() {
        String usetPassWord = sharedPreferences.getString("usetPassWord", null);
        return usetPassWord;
    }*/


    //清除用户信息
    public void deleteUsetInfo() {
        sharedPreferences.edit().remove("user").remove("userId").remove("usetName").commit();
    }

    //获取申请继养师审核是否通过标识
    public int getState() {
        int state = sharedPreferences.getInt("userState", 0);
        return state;
    }

    //获取用户手机
    public long getUsetPhono() {
        long userPhono = sharedPreferences.getLong("usetPhono", 0);
        return userPhono;
    }
}
