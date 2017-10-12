package com.example.the.instacopy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.the.instacopy.utils.ContextUtil;
import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AddNewsfeedActivity extends BaseActivity {

    Bitmap bitmap;
    int PICK_FROM_ALBUM = 0;

    private android.widget.ImageView backImg;
    private android.widget.TextView contentBtn;
    private android.widget.EditText contentEdt;
    private ImageView newsImg;

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

        // 서버에 게시물을 공유
        contentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentEdt.getText().toString().equals("") || bitmap == null) {
                    Toast.makeText(mContext, "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    ServerUtil.updateProfilePhoto(mContext, ContextUtil.getLoginUser(mContext).getId(), bitmap, contentEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                        @Override
                        public void onResponse(JSONObject json) {
                            try {
                                if (json.getBoolean("result")) {
                                    Toast.makeText(mContext, "성공", Toast.LENGTH_SHORT).show();
                                    contentEdt.setText("");
                                    finish();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        newsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, PICK_FROM_ALBUM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (PICK_FROM_ALBUM == 0) {
                Uri uri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    newsImg.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Override
    public void setValues() {
    }

    @Override
    public void bindViews() {
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.newsImg = (ImageView) findViewById(R.id.newsImg);
        this.contentBtn = (TextView) findViewById(R.id.contentBtn);
        this.backImg = (ImageView) findViewById(R.id.backImg);
    }
}
