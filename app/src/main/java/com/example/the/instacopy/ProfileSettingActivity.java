package com.example.the.instacopy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.the.instacopy.utils.ContextUtil;

public class ProfileSettingActivity extends BaseActivity {

    private android.widget.LinearLayout ChangeProfileImg;
    String[] profileMenu = {"프로필 사진 설정", "새 프로필 사진", "Facebook에서 가져오기", "Twitter에서 가져오기", "프로필 사진 삭제"};
    private android.widget.EditText nameEdt;
    private android.widget.EditText idEdt;
    private android.widget.ImageView cancelBtn;
    private android.widget.ImageView okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);



        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        ChangeProfileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setItems(profileMenu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
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
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.ChangeProfileImg = (LinearLayout) findViewById(R.id.ChangeProfileImg);
        this.okBtn = (ImageView) findViewById(R.id.okBtn);
        this.cancelBtn = (ImageView) findViewById(R.id.cancelBtn);
    }
}
