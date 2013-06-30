package com.tech_tec.qiitarian;

import com.tech_tec.qiitarian.di.ProdApplicationModule;

import android.app.Application;
import dagger.ObjectGraph;

public class QiitarianApplication extends Application {
    
    private ObjectGraph mObjectGraph;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mObjectGraph = ObjectGraph.create(new ProdApplicationModule(this));
    }
    
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
}
