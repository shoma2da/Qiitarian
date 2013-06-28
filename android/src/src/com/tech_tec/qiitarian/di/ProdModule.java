package com.tech_tec.qiitarian.di;

import javax.inject.Singleton;

import android.content.Context;
import android.webkit.WebView;

import com.tech_tec.qiitarian.MainActivity;
import com.tech_tec.qiitarian.api.ApiAccessor;
import com.tech_tec.qiitarian.async.AuthAsyncTask;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = MainActivity.class
)
public class ProdModule {
    
    private Context mContext;
    
    public ProdModule(Context context) {
        mContext = context;
    }
    
    @Provides @Singleton
    ApiAccessor provideApiAccessor() {
        return new ApiAccessor(new WebView(mContext).getSettings().getUserAgentString());
    }
    
    @Provides
    Context provideContext() {
        return mContext;
    }
    
    @Provides
    AuthAsyncTask provideAuthAsyncTask(ApiAccessor apiAccessor, Context context) {
        return new AuthAsyncTask(context, apiAccessor);
    }
}
