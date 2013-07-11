package com.tech_tec.qiitarian.util.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class Requests {
    
    public static final String BASE_URL = "https://qiita.com/api/v1";
    
    public HttpUriRequest items() {
        return new HttpGet(BASE_URL + "/items");
    }
    
}
