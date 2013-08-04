package com.tech_tec.qiitarian.model.user.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.http.ClientBase;
import com.tech_tec.qiitarian.model.items.UserUrlName;

public class UserClient extends ClientBase {
    
    private UserUrlName mUrlName;
    
    public UserClient(UserUrlName urlName) {
        mUrlName = urlName;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        return new HttpGet(String.format("https://qiita.com/api/v1/users/%s", mUrlName.toString()));
    }
    
}
