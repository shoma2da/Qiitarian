package com.tech_tec.qiitarian.di;

import javax.inject.Singleton;

import com.tech_tec.qiitarian.MainActivity;
import com.tech_tec.qiitarian.model.AuthInfo;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = MainActivity.class
)
public class ProdModule {
    
    @Provides @Singleton
    AuthInfo provideAuthInfo() {
        return new AuthInfo();
    }
}
