package com.tech_tec.qiitarian.model.user.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.http.ClientBase;
import com.tech_tec.qiitarian.model.items.UrlName;

public class UserClient extends ClientBase {
    
    private UrlName mUrlName;
    
    public UserClient(UrlName urlName) {
        mUrlName = urlName;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        return new HttpGet(String.format("https://qiita.com/api/v1/users/%s", mUrlName.toString()));
    }
    
}
