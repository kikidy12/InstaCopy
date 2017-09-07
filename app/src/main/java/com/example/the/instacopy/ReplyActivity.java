package com.example.the.instacopy;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ReplyActivity extends BaseActivity {

    private android.widget.ImageView backImg;
    private android.widget.ListView replyListView;
    private android.widget.TextView okBtn;
    private android.widget.EditText commentEdt;

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
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentEdt.getText().toString();
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.okBtn = (TextView) findViewById(R.id.okBtn);
        this.commentEdt = (EditText) findViewById(R.id.commentEdt);
        this.replyListView = (ListView) findViewById(R.id.replyListView);
        this.backImg = (ImageView) findViewById(R.id.backImg);
    }
}
