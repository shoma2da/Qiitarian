package com.tech_tec.qiitarian.activity;

import android.support.v4.app.FragmentActivity;

import com.google.analytics.tracking.android.EasyTracker;

public class QiitarianFragmentActivity extends FragmentActivity {
    
    @Override
    protected final void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }
    
    @Override
    protected final void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
    }
    

}
