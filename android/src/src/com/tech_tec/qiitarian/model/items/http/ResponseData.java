package com.tech_tec.qiitarian.model.items.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;

public class ResponseData {
    
    private StatusLine mStatusLine;
    private HttpEntity mEntity;
    
    public ResponseData(StatusLine statusLine, HttpEntity entity) {
        mStatusLine = statusLine;
        mEntity = entity;
    }
    
    public InputStream getInputStream() throws IllegalStateException, IOException {
        return mEntity.getContent();
    }
    
    public boolean isOK() {
        return mStatusLine.getStatusCode() == 200;
    }
    
}
