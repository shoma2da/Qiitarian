package com.tech_tec.qiitarian.model.items.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.http.ClientBase;

public class ItemsClient extends ClientBase {
    
    @Override
    protected HttpUriRequest createRequest() {
        return new HttpGet("https://qiita.com/api/v1/items");
    }
    
}
