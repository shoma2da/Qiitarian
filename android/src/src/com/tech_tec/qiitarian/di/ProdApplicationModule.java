package com.tech_tec.qiitarian.di;

import javax.inject.Singleton;

import android.app.Application;
import android.webkit.WebView;

import com.tech_tec.qiitarian.activity.HomeActivity;
import com.tech_tec.qiitarian.activity.LaunchActivity;
import com.tech_tec.qiitarian.activity.LoginActivity;
import com.tech_tec.qiitarian.model.AuthInfo;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = { LoginActivity.class, LaunchActivity.class, HomeActivity.class }
)
public class ProdApplicationModule {
    
    private Application mApplication;
    
    public ProdApplicationModule(Application application) {
        mApplication = application;
    }
    
    @Provides @Singleton
    AuthInfo provideAuthInfo() {
        String userAgent = new WebView(mApplication).getSettings().getUserAgentString();
        AuthInfo authInfo = AuthInfo.getInstance(mApplication, userAgent);
        return authInfo;
    }
}
