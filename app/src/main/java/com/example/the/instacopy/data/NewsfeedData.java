package com.example.the.instacopy.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class NewsfeedData implements Serializable {

    private int newsfeedId;
    private String imageURL;
    private String content;
    private int likeCount; // 좋아요 개수

    private User writer;

    public static NewsfeedData getNewsfeedFromJsonObject(JSONObject json) {
        NewsfeedData tempNews = new NewsfeedData();

        try {
            tempNews.setNewsfeedId(json.getInt("id"));
            tempNews.setImageURL(json.getString("profile_url"));

            tempNews.setWriter(User.getUserFromJsonObject(json.getJSONObject("user")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tempNews;
    }

    public NewsfeedData() {

    }

    public NewsfeedData(int newsfeedId, String imageURL, String content, int likeCount, User writer) {
        this.newsfeedId = newsfeedId;
        this.imageURL = imageURL;
        this.content = content;
        this.likeCount = likeCount;
        this.writer = writer;
    }

    public NewsfeedData(int newsfeedId, String imageURL, int likeCount, User writer) {
        this.newsfeedId = newsfeedId;
        this.imageURL = imageURL;
        this.likeCount = likeCount;
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNewsfeedId() {
        return newsfeedId;
    }

    public void setNewsfeedId(int newsfeedId) {
        this.newsfeedId = newsfeedId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }
}
