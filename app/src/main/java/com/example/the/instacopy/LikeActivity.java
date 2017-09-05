package com.example.the.instacopy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.the.instacopy.adapter.NotificationAdapter;
import com.example.the.instacopy.datas.NotificationData;

import java.util.ArrayList;
import java.util.List;

public class LikeActivity extends BaseActivity {


    private android.widget.Button logoutBtn;
    private android.widget.ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;
    private android.widget.TextView textView;
    private android.widget.ListView myNotiListView;
    private android.widget.LinearLayout activityLayout;
    private android.widget.ListView myPostListView;
    private android.widget.LinearLayout myProfileLayout;
    private android.widget.ImageView tabBtn1;
    private android.widget.ImageView tabBtn2;
    private android.widget.ImageView tabBtn3;
    private android.widget.ImageView tabBtn4;
    private android.widget.ImageView tabBtn5;

    NotificationAdapter myNotiAdapter;
    List<NotificationData> DataList = new ArrayList<>();
    private ListView likeListView;
    private LinearLayout likeListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {


        myNotiAdapter = new NotificationAdapter(mContext, DataList);
        likeListView.setAdapter(myNotiAdapter);

    }

    @Override
    public void bindViews() {
        this.tabBtn5 = (ImageView) findViewById(R.id.tabBtn5);
        this.tabBtn4 = (ImageView) findViewById(R.id.tabBtn4);
        this.tabBtn3 = (ImageView) findViewById(R.id.tabBtn3);
        this.tabBtn2 = (ImageView) findViewById(R.id.tabBtn2);
        this.tabBtn1 = (ImageView) findViewById(R.id.tabBtn1);
        this.myProfileLayout = (LinearLayout) findViewById(R.id.myProfileLayout);
        this.myPostListView = (ListView) findViewById(R.id.myPostListView);
        this.activityLayout = (LinearLayout) findViewById(R.id.activityLayout);
        this.myNotiListView = (ListView) findViewById(R.id.myNotiListView);
        this.textView = (TextView) findViewById(R.id.textView);
        this.likeListLayout = (LinearLayout) findViewById(R.id.likeListLayout);
        this.likeListView = (ListView) findViewById(R.id.likeListView);

    }
}
