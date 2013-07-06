package com.tech_tec.qiitarian.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

public class JsonHttpClient {
    
    HttpClient mRealClieant;
    
    public void execute(HttpUriRequest request) throws ClientProtocolException, IOException {
        mRealClieant.execute(request);
        mRealClieant.getConnectionManager().shutdown();
    }
    
}
