package com.tech_tec.qiitarian.di;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Singleton;

import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.webkit.WebView;

import com.tech_tec.qiitarian.activity.MainActivity;
import com.tech_tec.qiitarian.api.ApiAccessor;
import com.tech_tec.qiitarian.api.ApiAccessor.AndroidHttpClientFactory;
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
        AndroidHttpClientFactory httpClientFactory = new AndroidHttpClientFactory() {
            @Override
            public AndroidHttpClient create() {
                return AndroidHttpClient.newInstance(userAgent);
            }
        };
        JSONObjectFactory jsonObjectFactory = new JSONObjectFactory() {
            @Override
            public JSONObject create(HttpResponse response) throws IOException, JSONException {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                response.getEntity().writeTo(outputStream);
                String rawJson = outputStream.toString();
                outputStream.close();
                
                return new JSONObject(rawJson);
            }
        };
        return new ApiAccessor(httpClientFactory, jsonObjectFactory);
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
