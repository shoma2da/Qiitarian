package com.tech_tec.qiitarian.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.activity.home.HomeActivity;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;

public class LaunchActivity extends QiitarianActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        
        new WaitAsyncTask().execute();
    }
    
    private void gotoNextActivity() {
        AuthInfo authInfo = loadAuthInfo();
        
        if (authInfo != null && authInfo.isValid()) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        
        finish();
    }
    
    private AuthInfo loadAuthInfo() {
        return new AuthInfoPreferences(getApplicationContext()).load();
    }
    
    private class WaitAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            gotoNextActivity();
        }
    }
}
