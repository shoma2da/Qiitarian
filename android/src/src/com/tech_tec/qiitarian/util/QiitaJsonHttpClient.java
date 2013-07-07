package com.tech_tec.qiitarian.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class QiitaJsonHttpClient {
    
    HttpClient mRealClieant;
    
    public QiitaJsonHttpClient() {
        mRealClieant = new DefaultHttpClient();
    }
    
    public InputStream execute(HttpUriRequest request) throws ClientProtocolException, IOException {
        HttpResponse response = mRealClieant.execute(request);
        InputStream input = response.getEntity().getContent();
        
        mRealClieant.getConnectionManager().shutdown();
        
        return input;
    }
    
}
