package com.example.the.instacopy;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.the.instacopy.utils.ContextUtil;
import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class AddNewsfeedActivity extends BaseActivity {

    private android.widget.ImageView backImg;
    private android.widget.TextView contentBtn;
    private android.widget.EditText contentEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_newsfeed);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        contentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.updateProfilePhoto(mContext, ContextUtil.getLoginUser(mContext).getId(), null, contentEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if(json.getBoolean("result")) {
                                Toast.makeText(mContext, "성공", Toast.LENGTH_SHORT).show();
                                contentEdt.setText("");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

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
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.contentBtn = (TextView) findViewById(R.id.contentBtn);
        this.backImg = (ImageView) findViewById(R.id.backImg);
    }
}
