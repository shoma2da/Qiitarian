package com.tech_tec.qiitarian.di;

import javax.inject.Singleton;

import org.apache.http.client.HttpClient;

import android.app.Application;
import android.net.http.AndroidHttpClient;
import android.webkit.WebView;

import com.tech_tec.qiitarian.activity.HomeActivity;
import com.tech_tec.qiitarian.activity.LaunchActivity;
import com.tech_tec.qiitarian.activity.LoginActivity;
import com.tech_tec.qiitarian.old.model.AuthInfo;
import com.tech_tec.qiitarian.old.model.AuthInfo.HttpClientFactory;

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
    AuthInfo provideAuthInfo(HttpClientFactory factory) {
        AuthInfo authInfo = new AuthInfo(mApplication, factory);
        return authInfo;
    }
    
    @Provides @Singleton
    HttpClientFactory provideHttpClientFactory() {
        final String userAgent = new WebView(mApplication).getSettings().getUserAgentString();
        return new HttpClientFactory() {
            @Override
            public HttpClient create() {
                return AndroidHttpClient.newInstance(userAgent);
            }
        };
    }
}
