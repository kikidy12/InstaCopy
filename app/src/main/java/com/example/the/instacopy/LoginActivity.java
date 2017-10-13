package com.example.the.instacopy;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the.instacopy.data.User;
import com.example.the.instacopy.utils.ContextUtil;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends BaseActivity {

    int ij = 0;
    CallbackManager cm;
    ProfileTracker pt;

    private android.widget.Button loginBtn;
    private com.facebook.login.widget.LoginButton fbloginBtn;
    private EditText idEdt;
    private EditText pwEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.the.instacopy",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }


        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UserData myData = new UserData(542, "아이유", "iu", "아이유사진경로");
//
//                // ContextUtil을 이용해서 저장.
//                ContextUtil.setLoginUser(mContext, myData);

                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    public void setValues() {

        cm = CallbackManager.Factory.create();
        fbloginBtn.registerCallback(cm, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        pt = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                Log.d("페이스북로그인", "로그인 감지");

                if (currentProfile == null) {
//                    로그아웃 된 경우
                    Toast.makeText(mContext, "페이스북 로그아웃 성공", Toast.LENGTH_SHORT).show();
                }
                else {

                    User temp = new User(0, currentProfile.getId(), currentProfile.getName(), currentProfile.getProfilePictureUri(200, 200).toString());

                    ContextUtil.login(mContext, temp);

//                    로그인이 된 경우
                    Toast.makeText(mContext, "로그인한 사람 : " + currentProfile.getName(), Toast.LENGTH_SHORT).show();



//                    로그인에 성공했으니, 메인 화면으로 넘어가게.
                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                    finish();


                }

            }
        };




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cm.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void bindViews() {
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.fbloginBtn = (LoginButton) findViewById(R.id.fb_loginBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);

    }
}

