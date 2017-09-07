package com.example.the.instacopy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyProfileOptionActivity extends BaseActivity {

    private android.widget.TextView textView;
    private android.widget.TextView idPlusTxt;
    private android.widget.TextView LogoutTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_option);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        LogoutTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyProfileOptionActivity.this);
                builder.setTitle ( " 로그아웃 " );
                builder.setMessage ( " 정말 로그아웃하시겠습니까? " );
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(mContext, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton ( "취소", null );


                builder.show();
            }
        });




        //                계정추가 버튼 누를 시 적용되는 이벤트

        idPlusTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.LogoutTxt = (TextView) findViewById(R.id.LogoutTxt);
        this.idPlusTxt = (TextView) findViewById(R.id.idPlusTxt);
    }
}
