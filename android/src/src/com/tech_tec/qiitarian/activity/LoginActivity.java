package com.tech_tec.qiitarian.activity;

import javax.inject.Inject;
import javax.inject.Provider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tech_tec.qiitarian.QiitarianApplication;
import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.api.ApiAccessor;
import com.tech_tec.qiitarian.async.AuthAsyncTask;
import com.tech_tec.qiitarian.async.AuthAsyncTask.OnAuthListener;
import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.LoginService;

public class LoginActivity extends Activity {
    
    @Inject ApiAccessor mApiAccessor;
    @Inject Provider<AuthAsyncTask> mAuthAsyncTask;
    
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
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String service  = getServiceString();
                
                AuthAsyncTask asyncTask = mAuthAsyncTask.get();
                asyncTask.addOnAuthListener(new OnAuthListener() {
                    @Override
                    public void onAuth(boolean hasError, AuthInfo authInfo, boolean isAuthed) {
                        if (hasError) {
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        
                        if (isAuthed) {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "ユーザ名かパスワードが間違っています", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                asyncTask.execute(username, password, service);
            }
            private String getServiceString() {
                int checkedId = loginServiceGroup.getCheckedRadioButtonId();
                if (R.id.radio_login_by_github == checkedId) {
                    return LoginService.GITHUB.toString();
                } else if (R.id.radio_login_by_twitter == checkedId) {
                    return LoginService.TWITTER.toString();
                }
                return null;
            }
        });
        
    }
}
