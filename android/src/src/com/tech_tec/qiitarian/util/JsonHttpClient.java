package com.tech_tec.qiitarian.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class JsonHttpClient {
    
    HttpClient mRealClieant;
    
    public JsonHttpClient() {
        mRealClieant = new DefaultHttpClient();
    }
    
    public void execute(HttpUriRequest request) throws ClientProtocolException, IOException {
        mRealClieant.execute(request);
        mRealClieant.getConnectionManager().shutdown();
    }
    
}
