package com.example.the.instacopy.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class User implements Serializable {

    private int id;
    private String userId;
    private String name;
    private String passWord;
    private String profileImgURL;
    private String emailAddress;
    private String phoneNum;

    public static User getUserFromJsonObject(JSONObject json) {
        User tempUser = new User();
        try {
            tempUser.setId(json.getInt("id"));
            tempUser.setUserId(json.getString("userId"));
            tempUser.setName(json.getString("name"));
            tempUser.setPassWord(json.getString("password"));
            tempUser.setProfileImgURL(json.getString("profileImgURL"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tempUser;
    }

    public User() {

    }

    public User(int id, String userId, String name, String passWord, String profileImgURL, String emailAddress, String phoneNum) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.passWord = passWord;
        this.profileImgURL = profileImgURL;
        this.emailAddress = emailAddress;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
