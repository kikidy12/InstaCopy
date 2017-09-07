package com.example.the.instacopy.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.the.instacopy.data.User;

/**
 * Created by the on 2017-09-06.
 */

public class ContextUtil {

    private static User loginUser = null;

    private final static String prefName = "instaCopy";
    private final static String ID = "ID";
    private final static String USER_ID = "UESR_ID";
    private final static String USER_NAME = "USE_NAME";
    private final static String USER_PROFILE_URL = "USER_PROFILE_URL";

    public static void logout(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID, 0).commit();
        pref.edit().putString(USER_ID, "").commit();
        pref.edit().putString(USER_NAME, "").commit();
        pref.edit().putString(USER_PROFILE_URL, "").commit();

        loginUser = null;


    }

    public static void login(Context context, User loginUser) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID, loginUser.getId()).commit();
        pref.edit().putString(USER_ID, loginUser.getUserId()).commit();
        pref.edit().putString(USER_NAME, loginUser.getName()).commit();
        pref.edit().putString(USER_PROFILE_URL, loginUser.getProfileImgURL()).commit();
    }

    public static User getLoginUser(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if (pref.getString(USER_ID, "").equals("")) {
//            로그인이 안된 상태
            loginUser = null;
        }
        else {
            loginUser = new User();
            loginUser.setId(pref.getInt(ID, 0));
            loginUser.setUserId(pref.getString(USER_ID, ""));
            loginUser.setName(pref.getString(USER_NAME, ""));
            loginUser.setProfileImgURL(pref.getString(USER_PROFILE_URL, ""));
        }

        return loginUser;
    }
}
