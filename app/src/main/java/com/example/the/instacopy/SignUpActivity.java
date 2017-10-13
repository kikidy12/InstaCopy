package com.example.the.instacopy;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.Button checkDuplBtn;
    private android.widget.EditText pwEdt;
    private android.widget.Button signUpBtn;
    private EditText nameEdt;
    boolean isIdOk = false;
    private EditText eMailEdt;
    private EditText phoneNumEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        checkDuplBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.check_dupl_id(mContext, idEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {
                                isIdOk = true;
                                Toast.makeText(mContext, "사용해도 좋은 아이디입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                isIdOk = false;
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setTitle("가입 불가");
                                builder.setMessage("이미 사용중인 아이디입니다. 다시 입력하세요.");
                                builder.setPositiveButton("확인", null);
                                builder.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isIDOk = !idEdt.getText().toString().equals("");
                if (!isIDOk) {
                    Toast.makeText(mContext, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isPwOk = !pwEdt.getText().toString().equals("");
                if (!isPwOk) {
                    Toast.makeText(mContext, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isNameOk = !nameEdt.getText().toString().equals("");
                if (!isNameOk) {
                    Toast.makeText(mContext, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isMailOk = !eMailEdt.getText().toString().equals("");
                if (!isMailOk) {
                    Toast.makeText(mContext, "메일주소를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isPhoneNumOk = !phoneNumEdt.getText().toString().equals("");
                if (!isPhoneNumOk) {
                    Toast.makeText(mContext, "전화번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                ServerUtil.sign_up(mContext,
                        idEdt.getText().toString(),
                        pwEdt.getText().toString(),
                        nameEdt.getText().toString(),
                        eMailEdt.getText().toString(),
                        phoneNumEdt.getText().toString(),
                        new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {
                                Toast.makeText(mContext, "회원가입 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(mContext, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.phoneNumEdt = (EditText) findViewById(R.id.phoneNumEdt);
        this.eMailEdt = (EditText) findViewById(R.id.eMailEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.checkDuplBtn = (Button) findViewById(R.id.checkDuplBtn);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
