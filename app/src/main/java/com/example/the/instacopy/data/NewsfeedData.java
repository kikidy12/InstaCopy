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

    private int postingId;
    private String imageURL;
    private String content;

    private User writerData;

    public static NewsfeedData getNewsfeedFromJsonObject(JSONObject json) {
        NewsfeedData tempNews = new NewsfeedData();

        try {
            tempNews.setPostingId(json.getInt("id"));
            tempNews.setImageURL(json.getString("profile_url"));
            tempNews.setContent(json.getString("content"));

            tempNews.setWriterData(User.getUserFromJsonObject(json.getJSONObject("writer")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tempNews;
    }

    public NewsfeedData() {

    }

    public NewsfeedData(int postingId, String imageURL, String content, User writerData) {
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
}
