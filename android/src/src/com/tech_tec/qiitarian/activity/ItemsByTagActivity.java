package com.tech_tec.qiitarian.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;

public class ItemsByTagActivity extends FragmentActivity implements FactoryGettable {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_by_tag);
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        return null;
    }
    
}
