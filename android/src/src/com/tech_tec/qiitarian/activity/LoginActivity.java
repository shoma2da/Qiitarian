package com.tech_tec.qiitarian.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.activity.task.AuthInfoFetcherCallbackImpl;
import com.tech_tec.qiitarian.activity.task.FetchAuthInfoTask;
import com.tech_tec.qiitarian.model.auth.LoginService;

public class LoginActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                
                new FetchAuthInfoTask(username, password, service, new AuthInfoFetcherCallbackImpl(LoginActivity.this)).execute();
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
        
    }

}
