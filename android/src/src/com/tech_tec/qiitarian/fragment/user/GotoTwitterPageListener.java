package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.user.User;

public class GotoTwitterPageListener implements OnClickListener {
    
    private Context mContext;
    private User mUser;
    
    public GotoTwitterPageListener(User user, Context context) {
        mUser = user;
        mContext = context;
    }
    
    @Override
    public void onClick(View v) {
        String urlStr = mContext.getString(R.string.twitter_url, mUser.getTwitterName());
        
        Uri uri = Uri.parse(urlStr);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        mContext.startActivity(intent);
    }

}
