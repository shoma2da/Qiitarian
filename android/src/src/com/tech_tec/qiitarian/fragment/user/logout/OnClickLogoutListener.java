package com.tech_tec.qiitarian.fragment.user.logout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

import com.tech_tec.qiitarian.activity.LaunchActivity;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;

public class OnClickLogoutListener implements OnClickListener {
    
    private Activity mActivity;
    private AuthInfoPreferences mPreferences;
    
    public OnClickLogoutListener(Activity activity, AuthInfoPreferences preferences) {
        mActivity = activity;
        mPreferences = preferences;
    }
    
    @Override
    public void onClick(DialogInterface dialog, int which) {
        mPreferences.clear();
        
        //スプラッシュ画面に戻る
        Intent intent = new Intent(mActivity, LaunchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        mActivity.startActivity(intent);
        
        mActivity.finish();
    }

}
