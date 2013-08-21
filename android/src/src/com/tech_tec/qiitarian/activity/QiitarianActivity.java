package com.tech_tec.qiitarian.activity;

import android.app.Activity;

import com.google.analytics.tracking.android.EasyTracker;

public abstract class QiitarianActivity extends Activity {
    
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
