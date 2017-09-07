package com.example.the.instacopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class ReplyActivity extends BaseActivity {

    private android.widget.ImageView backImg;
    private android.widget.ListView replyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        bindViews();
        setupEvents();
        setValues();
    }


    @Override
    public void setupEvents() {

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.replyListView = (ListView) findViewById(R.id.replyListView);
        this.backImg = (ImageView) findViewById(R.id.backImg);
    }
}
