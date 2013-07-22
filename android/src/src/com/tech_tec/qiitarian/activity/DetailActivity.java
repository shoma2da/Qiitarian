package com.tech_tec.qiitarian.activity;

import android.app.Activity;
import android.os.Bundle;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.content.detail.DetailFragment.ItemUuidGettable;

public class DetailActivity extends Activity implements ItemUuidGettable {
    
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
