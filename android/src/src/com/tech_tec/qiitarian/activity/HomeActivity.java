package com.tech_tec.qiitarian.activity;

import javax.inject.Inject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.tech_tec.qiitarian.QiitarianApplication;
import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.content.TagsFragment;
import com.tech_tec.qiitarian.fragment.content.UserFragment;
import com.tech_tec.qiitarian.fragment.content.list.ItemsFragment;
import com.tech_tec.qiitarian.model.AuthInfo;

public class HomeActivity extends FragmentActivity {
    
    @Inject AuthInfo authInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        ((QiitarianApplication)getApplication()).getObjectGraph().inject(this);
        
        showLatestFragment();
        
        Fragment tabFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_tab);
        RadioGroup tabs = (RadioGroup)tabFragment.getView().findViewById(R.id.radio_group_tabs);
        tabs.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.radio_latest == checkedId) {
                    showLatestFragment();
                } else if (R.id.radio_tags == checkedId) {
                    showTagsFragment();
                } else {
                    showUserFragment();
                }
            }
        });
    }
    
    private void showLatestFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_container, new ItemsFragment());
        transaction.commit();
    }
    
    private void showTagsFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_container, new TagsFragment());
        transaction.commit();
    }
    
    private void showUserFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_container, new UserFragment());
        transaction.commit();
    }
}
