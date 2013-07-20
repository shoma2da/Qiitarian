package com.tech_tec.qiitarian.model.items.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class ItemsClient {
    
    public HttpResponseWrapper execute() throws ClientProtocolException, IOException {
        HttpClient client = createHttpClient();
        HttpUriRequest request = createRequest();
                
        Log.d("qiitarian", "access to " + request.getURI());
        HttpResponse response = client.execute(request);
        
        return new HttpResponseWrapper(response);
    }
    
    HttpClient createHttpClient() {
        return new DefaultHttpClient();
    }
    
    HttpUriRequest createRequest() {
        //TODO ほんとはUAを取得しなければ？
        return new HttpGet("https://qiita.com/api/v1/items");
    }
    
}
