package jiyun.com.lovepet.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;

import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.user.UserInfo;
import jiyun.com.lovepet.utils.TokenUtil;

/**
 * Created by 阿三 on 2017/12/11.
 */
public class UserManager {

  private static UserManager userManager;
  private UserInfo userInfo;
  private SharedPreferences sharedPreferences;
    public synchronized static UserManager getIntance(){
        if(userManager==null){
            userManager=new UserManager();
        }
        return userManager;

    }
    public UserManager(){
        sharedPreferences= App.getInstance().getSharedPreferences("user_info",0);
    }

    //保存当前用户
     public void saveUser(UserInfo userInfo){
         if(userInfo==null){
             return;
         }
         this.userInfo=userInfo;
         sharedPreferences.edit().putString("user",userInfo.toString());
     }
    public UserInfo getUserInfo(){
        return userInfo;
    }

   //用户是否登陆
     public boolean isLogin(){
        String userId= sharedPreferences.getString("userId",null);
         return !TextUtils.isEmpty(userId);
     }
     public void saceLogin(){
         sharedPreferences.edit().putString("userId",userInfo.getUserId());
     }

    //清除用户信息
    public void clearUser(){
        userInfo=null;
        saveUser(userInfo);

    }
    //获取Token
    public void saveToken(){
        sharedPreferences.edit().putString("token", TokenUtil.createToken());
    }
    public String getToken(){
        String token=sharedPreferences.getString("token",null);
        return token;
    }
}
