package com.tech_tec.qiitarian.fragment.list;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.activity.user.UserActivity;
import com.tech_tec.qiitarian.model.common.UserUrlName;

public class GotoUserActivityListener implements OnClickListener {
    
    private Context mContext;
    private UserUrlName mUserUrlName;
    
    public GotoUserActivityListener(Context context, UserUrlName userUrlName) {
        mContext = context;
        mUserUrlName = userUrlName;
    }
    
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, UserActivity.class);
        intent.putExtra(UserActivity.KEY_USER_URLNAME, mUserUrlName);
        mContext.startActivity(intent);
    }

}
