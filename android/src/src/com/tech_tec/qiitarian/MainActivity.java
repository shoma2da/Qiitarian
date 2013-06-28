package com.tech_tec.qiitarian;

import javax.inject.Inject;

import com.tech_tec.qiitarian.di.ProdModule;
import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.AuthInfo.Service;

import dagger.ObjectGraph;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
    
    @Inject AuthInfo mAuthInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObjectGraph objectGraph = ObjectGraph.create(new ProdModule());
        objectGraph.inject(this);
        
        setContentView(R.layout.activity_main);
        
        initViews();
    }
    
    private void initViews() {
        final EditText passwordEditText = (EditText)findViewById(R.id.edittext_password);
        
        Button loginButton = (Button)findViewById(R.id.button_login);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAuthInfo();
                
                Log.d("tech_tec", "-----------------------------");
                Log.d("tech_tec", "service is " + mAuthInfo.getService());
                Log.d("tech_tec", "name is " + mAuthInfo.getUsername());
                Log.d("tech_tec", "password is " + passwordEditText.getText().toString());
                Log.d("tech_tec", "-----------------------------");
            }
        });
    }
    
    private void updateAuthInfo() {
        final RadioButton twitterButton = (RadioButton)findViewById(R.id.radio_login_by_twitter);
        final RadioButton githubButton = (RadioButton)findViewById(R.id.radio_login_by_github);
        final EditText usernameEditText = (EditText)findViewById(R.id.edittext_user_name);
        
        if (twitterButton.isChecked()) {
            mAuthInfo.setService(Service.TWITTER);
        } else if (githubButton.isChecked()) {
            mAuthInfo.setService(Service.GITHUB);
        }
        mAuthInfo.setUsername(usernameEditText.getText().toString());
    }
}
