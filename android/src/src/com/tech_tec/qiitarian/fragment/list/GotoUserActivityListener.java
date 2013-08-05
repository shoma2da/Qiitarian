package com.tech_tec.qiitarian.fragment.list;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.activity.user.UserActivity;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.items.Item;

public class GotoUserActivityListener implements OnClickListener {
    
    private Context mContext;
    private Item mItem;
    
    public GotoUserActivityListener(Context context, Item item) {
        mContext = context;
        mItem = item;
    }
    
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, UserActivity.class);
        intent.putExtra(UserActivity.KEY_USER_URLNAME, new UserUrlName(mItem.getUserName()));
        mContext.startActivity(intent);
    }

}
