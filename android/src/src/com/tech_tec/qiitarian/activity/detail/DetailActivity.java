package com.tech_tec.qiitarian.activity.detail;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.detail.DetailFragment.ItemUuidGettable;

public class DetailActivity extends FragmentActivity implements ItemUuidGettable {
    
    public static final String KEY_ARG_OF_ITEM_UUID = "item_uuid";
    
    private String mUuidStr;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        mUuidStr = getIntent().getStringExtra(KEY_ARG_OF_ITEM_UUID);
    }

    @Override
    public String getUuid() {
        return mUuidStr;
    }
    
}
