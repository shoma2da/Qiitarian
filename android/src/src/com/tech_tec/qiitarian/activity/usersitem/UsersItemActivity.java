package com.tech_tec.qiitarian.activity.usersitem;

import android.os.Bundle;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.activity.QiitarianFragmentActivity;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;
import com.tech_tec.qiitarian.model.common.UserUrlName;

public class UsersItemActivity extends QiitarianFragmentActivity implements FactoryGettable {
    
    public static final String KEY_USER_URLNAME = "user_uslname";
    
    private UserUrlName mUserUrlName;
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_list_usersitem);
        
        String nameStr = getIntent().getStringExtra(KEY_USER_URLNAME);
        mUserUrlName = new UserUrlName(nameStr);

        TextView titleText = (TextView)findViewById(R.id.text_title);
        titleText.setText(mUserUrlName.toString() + "さんの投稿一覧");
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        return new CommandsFactoryImpl(mUserUrlName);
    }
    
}
