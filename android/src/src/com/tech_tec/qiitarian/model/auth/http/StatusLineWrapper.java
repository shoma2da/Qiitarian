package com.tech_tec.qiitarian.model.auth.http;

import org.apache.http.StatusLine;

public class StatusLineWrapper {
    
    private StatusLine mStatusLine;
    
    public StatusLineWrapper(StatusLine statusLine) {
        mStatusLine = statusLine;
    }
    
    public boolean isOK() {
        return mStatusLine.getStatusCode() == 200;
    }
    
}
