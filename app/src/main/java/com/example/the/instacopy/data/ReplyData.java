package com.example.the.instacopy.data;

import java.io.Serializable;

/**
 * Created by one on 2017-09-06.
 */

public class ReplyData implements Serializable {

    private int replyId; // 댓글 아이디
    private int newsfeedId; // 댓글이 달리는 뉴스피드 아이디
    private String replyContent; // 댓글 내용

    private User writter; // 댓글을 단 사용자의 정보

    public ReplyData() {
    }

    public ReplyData(int replyId, int newsfeedId, String replyContent, User writter) {
        this.replyId = replyId;
        this.newsfeedId = newsfeedId;
        this.replyContent = replyContent;
        this.writter = writter;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getNewsfeedId() {
        return newsfeedId;
    }

    public void setNewsfeedId(int newsfeedId) {
        this.newsfeedId = newsfeedId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public User getWritter() {
        return writter;
    }

    public void setWritter(User writter) {
        this.writter = writter;
    }
}
