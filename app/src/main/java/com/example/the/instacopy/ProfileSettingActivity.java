package com.example.the.instacopy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;

import com.example.the.instacopy.utils.ContextUtil;

public class ProfileSettingActivity extends BaseActivity {

    private android.widget.LinearLayout ChangeProfileImg;
    String[] profileMenu = {"프로필 사진 설정", "새 프로필 사진", "Facebook에서 가져오기", "Twitter에서 가져오기", "프로필 사진 삭제"};
    private android.widget.EditText nameEdt;
    private android.widget.EditText idEdt;
    private android.widget.ImageView cancelBtn;
    private android.widget.ImageView okBtn;
    private android.widget.TextView textView;
    private EditText emailEdt;
    private EditText phoneNumEdt;

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
                finish();
                Toast.makeText(mContext, "수정되었습니다.(기능없음)", Toast.LENGTH_SHORT).show();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        idEdt.setOnClickListener(clickListener);
        nameEdt.setOnClickListener(clickListener);
        emailEdt.setOnClickListener(clickListener);
        phoneNumEdt.setOnClickListener(clickListener);

    }

    @Override
    public void setValues() {
        idEdt.setText(ContextUtil.getLoginUser(mContext).getUserId());
        nameEdt.setText(ContextUtil.getLoginUser(mContext).getName());
        emailEdt.setText(ContextUtil.getLoginUser(mContext).getEmailAddress());
        phoneNumEdt.setText(ContextUtil.getLoginUser(mContext).getPhoneNum());
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText temp = (EditText) v;

            temp.setText("");
        }
    };

    @Override
    public void bindViews() {
        this.phoneNumEdt = (EditText) findViewById(R.id.phoneNumEdt);
        this.emailEdt = (EditText) findViewById(R.id.emailEdt);
        this.textView = (TextView) findViewById(R.id.textView);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.ChangeProfileImg = (LinearLayout) findViewById(R.id.ChangeProfileImg);
        this.okBtn = (ImageView) findViewById(R.id.okBtn);
        this.cancelBtn = (ImageView) findViewById(R.id.cancelBtn);
    }
}
