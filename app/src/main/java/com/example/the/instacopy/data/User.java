package com.example.the.instacopy.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by the on 2017-09-05.
 */

public class User implements Serializable {

    private int id;
    private String userId;
    private String userName;
    private String userProfileImgURL;

    public static User getUserFromJsonObject(JSONObject json) {
        User tempUser = new User();
        try {
            tempUser.setId(json.getInt("id"));
            tempUser.setUserId(json.getString("user_id"));
            tempUser.setUserName(json.getString("userName"));
            tempUser.setUserProfileImgURL(json.getString("userProfileImgURL"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tempUser;
    }

    public User() {

    }

    public User(int id, String userId, String name, String profileImgURL) {
        this.id = id;
        this.userId = userId;
        this.userName = name;
        this.userProfileImgURL = profileImgURL;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileImgURL() {
        return userProfileImgURL;
    }

    public void setUserProfileImgURL(String userProfileImgURL) {
        this.userProfileImgURL = userProfileImgURL;
    }
}
