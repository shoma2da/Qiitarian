package com.tech_tec.qiitarian.activity.userstocks;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;
import com.tech_tec.qiitarian.model.common.UserUrlName;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class UserStocksActivity extends FragmentActivity implements FactoryGettable {
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_list_userstocks);
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        return new UserStocksFactory(new UserUrlName("shoma2da"));
    }
    
}
