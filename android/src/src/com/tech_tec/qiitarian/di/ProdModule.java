package com.tech_tec.qiitarian.di;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Singleton;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.webkit.WebView;

import com.tech_tec.qiitarian.activity.MainActivity;
import com.tech_tec.qiitarian.api.ApiAccessor;
import com.tech_tec.qiitarian.api.ApiAccessor.JSONObjectFactory;
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
        final String userAgent = new WebView(mContext).getSettings().getUserAgentString();
        JSONObjectFactory jsonObjectFactory = new JSONObjectFactory() {
            @Override
            public JSONObject create(HttpRequestBase request) throws IOException, JSONException {
                AndroidHttpClient client = AndroidHttpClient.newInstance(userAgent);
                try {
                    HttpResponse response = client.execute(request);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    response.getEntity().writeTo(outputStream);
                    String rawJson = outputStream.toString();
                    outputStream.close();
                    
                    return new JSONObject(rawJson);
                } finally {
                    client.close();
                }
            }
        };
        
        return new ApiAccessor(jsonObjectFactory);
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
