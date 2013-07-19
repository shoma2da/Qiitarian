package com.tech_tec.qiitarian.model.items.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class ItemsClient {
    
    public HttpResponseWrapper execute() throws ClientProtocolException, IOException {
        HttpClient client = createHttpClient();
        HttpResponse response = client.execute(createRequest());
        
        return new HttpResponseWrapper(response.getStatusLine(), response.getEntity());
    }
    
    HttpClient createHttpClient() {
        return new DefaultHttpClient();
    }
    
    HttpUriRequest createRequest() {
        //TODO ほんとはUAを取得しなければ？
        return new HttpGet("https://qiita.com/api/v1/items");
    }
    
}
