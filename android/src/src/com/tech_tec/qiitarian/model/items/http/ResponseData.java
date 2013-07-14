package com.tech_tec.qiitarian.model.items.http;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;

public class ResponseData {
    
    private StatusLine mStatusLine;
    private HttpEntity mEntity;
    
    public ResponseData(StatusLine statusLine, HttpEntity entity) {
        mStatusLine = statusLine;
        mEntity = entity;
    }
    
    
}
