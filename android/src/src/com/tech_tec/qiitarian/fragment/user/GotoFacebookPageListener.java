package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.user.User;

public class GotoFacebookPageListener implements OnClickListener {
    
    private User mUser;
    private Context mContext;
    
    public GotoFacebookPageListener(User user, Context context) {
        mUser = user;
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        String urlBase = mContext.getString(R.string.facebook_url);
        Uri uri = Uri.parse(urlBase + mUser.getFacebookName());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        mContext.startActivity(intent);
    }

}
