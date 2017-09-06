package com.example.the.instacopy.datas;

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
    private Calendar createdAt; //언제 발생한 알림인지.
    private String actionType; // 좋아요, 댓글 구별
//    like : 좋아요, reply : 댓글

    // 관계


    public NotificationData() {
    }

    public NotificationData(int notificationId, Calendar createdAt, String actionType) {
        this.notificationId = notificationId;
        this.createdAt = createdAt;
        this.actionType = actionType;

    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }


}
