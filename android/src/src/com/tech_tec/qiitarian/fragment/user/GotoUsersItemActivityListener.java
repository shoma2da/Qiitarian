package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.activity.usersitem.UsersItemActivity;

public class GotoUsersItemActivityListener implements OnClickListener {
    
    private Context mContext;
    
    public GotoUsersItemActivityListener(Context context) {
        mContext = context;
    }
    
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, UsersItemActivity.class);
        mContext.startActivity(intent);
    }

}
