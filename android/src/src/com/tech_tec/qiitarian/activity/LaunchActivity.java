package com.tech_tec.qiitarian.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.old.model.AuthInfo;
import com.tech_tec.qiitarian.old.model.pref.AuthInfoPreferences;

public class LaunchActivity extends Activity {
    
    private AuthInfo mAuthInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        
        mAuthInfo = loadAuthInfo();
        
        if (hasAuthInfo()) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
    
    private boolean hasAuthInfo() {
        return mAuthInfo != null && mAuthInfo.getTokenStr() != null &&  mAuthInfo.getTokenStr().length() != 0;
    }
    
    private AuthInfo loadAuthInfo() {
        return new AuthInfoPreferences(getApplicationContext()).get();
    }
}
