package com.tech_tec.qiitarian.activity;

import javax.inject.Inject;

import com.tech_tec.qiitarian.QiitarianApplication;
import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.old.model.AuthInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LaunchActivity extends Activity {
    
    @Inject AuthInfo mAuthInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        
        ((QiitarianApplication)getApplication()).getObjectGraph().inject(this);
        
        if (hasAuthInfo()) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
    
    private boolean hasAuthInfo() {
        return mAuthInfo != null && mAuthInfo.getToken() != null &&  mAuthInfo.getToken().length() != 0;
    }
}
