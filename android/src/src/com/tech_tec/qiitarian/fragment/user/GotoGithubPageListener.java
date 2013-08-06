package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.user.User;

public class GotoGithubPageListener implements OnClickListener {
    
    private User mUser;
    private Context mContext;
    
    public GotoGithubPageListener(User user, Context context) {
        mUser = user;
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        String urlStr = mContext.getString(R.string.github_url, mUser.getGithubName());

        Uri uri = Uri.parse(urlStr);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        mContext.startActivity(intent);
    }

}
