package com.tech_tec.qiitarian.task.auth;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.tech_tec.qiitarian.activity.home.HomeActivity;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;
import com.tech_tec.qiitarian.task.auth.FetchAuthInfoTask.Callback;

public class AuthInfoFetchAction implements Callback {
    
    private Activity mActivity;
    private AuthInfoPreferences mPreferences;
    
    public AuthInfoFetchAction(Activity activity, AuthInfoPreferences preferences) {
        mActivity = activity;
        mPreferences = preferences;
    }
    
    @Override
    public void onSuccess(AuthInfo authInfo) {
        mPreferences.save(authInfo);
        
        Intent intent = new Intent(mActivity, HomeActivity.class);
        mActivity.startActivity(intent);
        
        mActivity.finish();
    }

    @Override
    public void onEmptySuccess() {
        Toast.makeText(mActivity, "ユーザ名かパスワードが違います", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(mActivity, "通信エラーが発生しています", Toast.LENGTH_SHORT).show();
    }

}
