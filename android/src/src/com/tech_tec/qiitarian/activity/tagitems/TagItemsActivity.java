package com.tech_tec.qiitarian.activity.tagitems;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class TagItemsActivity extends FragmentActivity implements FactoryGettable {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_by_tag);
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        return new TagItemsFactory(inflater, new UrlName("Java")/* TODO ダミー！！ */);
    }
    
}
