package com.tech_tec.qiitarian.activity;

import javax.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tech_tec.qiitarian.QiitarianApplication;
import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.AuthInfo.OnUpdateCallback;
import com.tech_tec.qiitarian.model.LoginService;
import com.tech_tec.qiitarian.model.ResponseType;

public class LoginActivity extends Activity implements OnUpdateCallback {
    
    @Inject AuthInfo mAuthInfo;
    private Handler mHandler = new Handler();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((QiitarianApplication)getApplication()).getObjectGraph().inject(this);
        
        setContentView(R.layout.activity_main);
        
        initViews();
    }
    
    private void initViews() {
        final EditText usernameEditText = (EditText)findViewById(R.id.edittext_user_name);
        final EditText passwordEditText = (EditText)findViewById(R.id.edittext_password);
        final RadioGroup loginServiceGroup = (RadioGroup)findViewById(R.id.radio_group_login_service);
        
        Button loginButton = (Button)findViewById(R.id.button_login);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();
                final LoginService service  = getService();
                
                new Thread(new Runnable() {
                    
                    @Override
                    public void run() {
                        mAuthInfo.updateAuthInfo(username, password, service, LoginActivity.this);
                    }
                }).start();
            }
            private LoginService getService() {
                int checkedId = loginServiceGroup.getCheckedRadioButtonId();
                if (R.id.radio_login_by_github == checkedId) {
                    return LoginService.GITHUB;
                } else if (R.id.radio_login_by_twitter == checkedId) {
                    return LoginService.TWITTER;
                }
                return null;
            }
        });
        
    }

    @Override
    public void onUpdate(final ResponseType type) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (type == ResponseType.SUCCESS) {
                    Toast.makeText(getApplicationContext(), "token : " + mAuthInfo.getToken(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else if (type == ResponseType.FAILED) {
                    Toast.makeText(getApplicationContext(), "ユーザ名かパスワードが違います", Toast.LENGTH_SHORT).show();
                } else if (type == ResponseType.ERROR) {
                    Toast.makeText(getApplicationContext(), "通信エラーが発生しています", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
