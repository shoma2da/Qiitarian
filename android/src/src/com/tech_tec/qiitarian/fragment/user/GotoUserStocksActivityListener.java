package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.activity.userstocks.UserStocksActivity;
import com.tech_tec.qiitarian.model.user.User;

public class GotoUserStocksActivityListener implements OnClickListener {
    
    private Context mContext;
    private User mUser;
    
    public GotoUserStocksActivityListener(Context context, User user) {
        mContext = context;
        mUser = user;
    }
    
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, UserStocksActivity.class);
        intent.putExtra(UserStocksActivity.KEY_USER_URLNAME, mUser.getNameStr());
        mContext.startActivity(intent);
    }

}
