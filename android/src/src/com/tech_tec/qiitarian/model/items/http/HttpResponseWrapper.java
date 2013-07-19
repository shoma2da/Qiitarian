package com.tech_tec.qiitarian.model.items.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class HttpResponseWrapper {
    
    private HttpResponse mResponse;
    
    public HttpResponseWrapper(HttpResponse response) {
        mResponse = response;
    }
    
    public InputStream getInputStream() throws IllegalStateException, IOException {
        return null;
        //return mEntity.getContent();
    }
    
    public boolean isOK() {
        return false;
    }
    
}
