package com.example.the.instacopy.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by the on 2017-09-05.
 */


public class NotificationData implements Serializable {
//    데이터 설계

//    ~~가, ~~게시글을, ~~합니다. (댓글 / 좋아요) (팔로우)
//    언제?

    //    고유 속성.
    private int notificationId; // 몇번째 Noti인지 DB와의 연동을 고려하는 변수.
    private String type; // 좋아요, 댓글 구별
//    like : 좋아요, reply : 댓글

    User wirter;
    NewsfeedData newsfeed;

    public NotificationData() {
    }

    public NotificationData(int notificationId, String type, User wirter, NewsfeedData newsfeed) {
        this.notificationId = notificationId;
        this.type = type;
        this.wirter = wirter;
        this.newsfeed = newsfeed;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getWirter() {
        return wirter;
    }

    public void setWirter(User wirter) {
        this.wirter = wirter;
    }

    public NewsfeedData getNewsfeed() {
        return newsfeed;
    }

    public void setNewsfeed(NewsfeedData newsfeed) {
        this.newsfeed = newsfeed;
    }
}
