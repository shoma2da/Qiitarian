package com.tech_tec.qiitarian.activity.userstocks;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;
import com.tech_tec.qiitarian.model.common.UserUrlName;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class UserStocksActivity extends FragmentActivity implements FactoryGettable {
    
    public static final String KEY_USER_URLNAME = "user_urlname";
    
    private UserUrlName mUserUrlName;
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_list_userstocks);
        
        String nameStr = getIntent().getStringExtra(KEY_USER_URLNAME);
        mUserUrlName = new UserUrlName(nameStr);
        
        TextView titleText = (TextView)findViewById(R.id.text_title);
        titleText.setText(mUserUrlName + "さんのストックしている投稿");
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        return new UserStocksFactory(mUserUrlName);
    }
    
}
