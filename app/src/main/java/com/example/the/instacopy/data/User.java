package com.example.the.instacopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class User implements Serializable {

    private int userId;
    private String name;
    private String nickName;
    private String profileImgURL;

    List<User> followers = new ArrayList<>();
    List<User> followings = new ArrayList<>();

    public User() {

    }

    public User(int userId, String name, String nickName, String profileImgURL) {
        this.userId = userId;
        this.name = name;
        this.nickName = nickName;
        this.profileImgURL = profileImgURL;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }
}
