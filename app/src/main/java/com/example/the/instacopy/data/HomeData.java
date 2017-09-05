package com.example.the.instacopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class HomeData implements Serializable {

    private int postingId;
    private String imageURL;
    private String content;

    private User writerData;
    private List<User> likeUsers = new ArrayList<>();
    private List<User> replies = new ArrayList<>();
    private List<String> hashTags = new ArrayList<>();

    public HomeData() {

    }

    public HomeData(int postingId, String imageURL, String content, User writerData) {
        this.postingId = postingId;
        this.imageURL = imageURL;
        this.content = content;
        this.writerData = writerData;
    }

    public int getPostingId() {
        return postingId;
    }

    public void setPostingId(int postingId) {
        this.postingId = postingId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getWriterData() {
        return writerData;
    }

    public void setWriterData(User writerData) {
        this.writerData = writerData;
    }

    public List<User> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(List<User> likeUsers) {
        this.likeUsers = likeUsers;
    }

    public List<User> getReplies() {
        return replies;
    }

    public void setReplies(List<User> replies) {
        this.replies = replies;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<String> hashTags) {
        this.hashTags = hashTags;
    }
}
