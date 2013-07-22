package com.tech_tec.qiitarian.activity.task;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.tech_tec.qiitarian.activity.HomeActivity;
import com.tech_tec.qiitarian.activity.task.FetchAuthInfoTask.Callback;
import com.tech_tec.qiitarian.model.auth.AuthInfo;

public class AuthInfoFetcherCallbackImpl implements Callback {
    
    private Activity mActivity;
    
    public AuthInfoFetcherCallbackImpl(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    public void onSuccess(AuthInfo authInfo) {
        Toast.makeText(mActivity, "token : " + authInfo.getTokenStr(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mActivity, HomeActivity.class);
        mActivity.startActivity(intent);
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
