package com.tech_tec.qiitarian.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.auth.LoginService;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;
import com.tech_tec.qiitarian.task.auth.AuthInfoFetchAction;
import com.tech_tec.qiitarian.task.auth.FetchAuthInfoTask;

public class LoginActivity extends QiitarianActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
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
                final String username = usernameEditText.getText().toString().trim();
                final String password = passwordEditText.getText().toString();
                final LoginService service  = getService();
                
                AuthInfoPreferences preferences = new AuthInfoPreferences(getApplicationContext());
                AuthInfoFetchAction action = new AuthInfoFetchAction(LoginActivity.this, preferences);
                new FetchAuthInfoTask(username, password, service, action, LoginActivity.this).execute();
            }
            private LoginService getService() {
                int checkedId = loginServiceGroup.getCheckedRadioButtonId();
                if (R.id.radio_login_by_github == checkedId) {
                    return LoginService.GITHUB;
                }
                if (R.id.radio_login_by_twitter == checkedId) {
                    return LoginService.TWITTER;
                }
                return null;
            }
        });
        
        findViewById(R.id.text_goto_qiita).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Uri uri = Uri.parse("https://qiita.com/settings/password");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

}
