package com.example.the.instacopy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.the.instacopy.data.NewsfeedData;
import com.example.the.instacopy.data.User;
import com.example.the.instacopy.utils.ContextUtil;
import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class NewsFeedDetailActivity extends BaseActivity {

    NewsfeedData mNewsfeed = null;
    String[] seemore = {"보관","공유하기","수정","삭제","댓글기능해제","공유URL복사"};
    boolean isheart = false;
    int currentLikeCount = 0;

    private android.widget.TextView idTxt;
    private android.widget.ImageView seeMoreBtn;
    private android.widget.ImageView imageView;
    private android.widget.ImageView heartImg;
    private android.widget.ImageView replyImg;
    private android.widget.TextView likeCountTxt;
    private android.widget.TextView contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_detail);
        bindViews();
        setupEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setValues();
    }

    @Override
    public void setupEvents() {
        seeMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setItems(seemore, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
            }
        });

        heartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isheart) {
                    settingLikeToServer();
                }
                else {
                    settingLikeToServer();
                }
            }
        });


        replyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {
        mNewsfeed = (NewsfeedData) getIntent().getSerializableExtra("뉴스정보");
        currentLikeCount = mNewsfeed.getLikeCount();
        idTxt.setText(mNewsfeed.getWriter().getUserId());
        if (mNewsfeed.getContent().toString().equals("")) {
            contentTxt.setText("내용이 없습니다.");
        }
        else {
            contentTxt.setText(mNewsfeed.getContent());
        }
        likeCountTxt.setText(currentLikeCount+"개");
        Glide.with(mContext).load("http://13.125.2.51/" + mNewsfeed.getImageURL()).into(imageView);

        for (User like : mNewsfeed.getLikeUsers()) {
            if (like.getId() == ContextUtil.getLoginUser(mContext).getId()) {
                heartImg.setImageResource(R.drawable.heart_black);
                isheart=true;
                break;
            }
            else {
                heartImg.setImageResource(R.drawable.empty_heart);
                isheart=false;
            }
        }
    }

    private void settingLikeToServer() {
        ServerUtil.like_or_unlike(mContext, ContextUtil.getLoginUser(mContext).getId(), mNewsfeed.getNewsfeedId(), new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    if (json.getBoolean("result")) {
                        Log.d("좋아요", json.getString("message"));
                        heartImg.setImageResource(R.drawable.heart_black);
                        isheart=true;
                        currentLikeCount++;
                    }
                    else {
                        Log.d("좋아요", json.getString("message"));
                        heartImg.setImageResource(R.drawable.empty_heart);
                        isheart=false;
                        currentLikeCount--;
                    }
                    likeCountTxt.setText(currentLikeCount+"개");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void bindViews() {
        this.contentTxt = (TextView) findViewById(R.id.contentTxt);
        this.likeCountTxt = (TextView) findViewById(R.id.likeCountTxt);
        this.replyImg = (ImageView) findViewById(R.id.replyImg);
        this.heartImg = (ImageView) findViewById(R.id.heartImg);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.seeMoreBtn = (ImageView) findViewById(R.id.seeMoreBtn);
        this.idTxt = (TextView) findViewById(R.id.idTxt);
    }
}
