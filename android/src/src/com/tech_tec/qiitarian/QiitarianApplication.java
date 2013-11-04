package com.tech_tec.qiitarian;

import android.app.Application;

import com.crittercism.app.Crittercism;

public class QiitarianApplication extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        if (BuildConfig.DEBUG) {
            QiitarianLog.d("Debug Mode");
            return;
        }
        Crittercism.init(getApplicationContext(), "520f0fa140020543f5000003");
    }
    
}
