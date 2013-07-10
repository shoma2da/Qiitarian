package com.tech_tec.qiitarian.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONException;
import org.json.JSONObject;


public class QiitaJsonService {
    
    public static final String BASE_URL = "https://qiita.com/api/v1";
    
    QiitaJsonHttpClient mClient;
    
    public QiitaJsonService() {
        mClient = new QiitaJsonHttpClient();
    }
    
    protected QiitaJsonHttpClient createQiitaClient() {
        return new QiitaJsonHttpClient();
    }
    
    public JSONObject lateLimit() throws JSONException, ClientProtocolException, IOException {
        return mClient.fetchJson(getLateLimitRequest());
    }
    
    protected HttpUriRequest getLateLimitRequest() {
        return new HttpGet(BASE_URL + "/rate_limit");
    }
    
}
