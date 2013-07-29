package com.tech_tec.qiitarian.model.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;


public abstract class ClientBase {
    
    private SendRequestStrategy mStrategy;
    
    public ClientBase() {
        mStrategy = new SendRequestStrategy();
    }
    
    public HttpResponseWrapper execute() throws ClientProtocolException, IOException {
        return mStrategy.execute(createRequest());
    }
    
    protected abstract HttpUriRequest createRequest();
}
