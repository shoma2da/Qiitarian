package com.tech_tec.qiitarian.activity.usersitem;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;
import com.tech_tec.qiitarian.model.common.UserUrlName;

public class UsersItemActivity extends FragmentActivity implements FactoryGettable {
    
    public static final String KEY_USER_URLNAME = "user_uslname";
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_list_usersitem);
        
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        String nameStr = getIntent().getStringExtra(KEY_USER_URLNAME);
        return new CommandsFactoryImpl(new UserUrlName(nameStr));
    }
    
}
