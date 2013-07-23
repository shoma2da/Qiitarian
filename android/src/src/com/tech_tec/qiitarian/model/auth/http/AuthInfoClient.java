package com.tech_tec.qiitarian.model.auth.http;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.auth.LoginService;
import com.tech_tec.qiitarian.model.http.ClientBase;

public class AuthInfoClient extends ClientBase {
    
    private String mUsername;
    private String mPassword;
    private LoginService mService;
    
    public AuthInfoClient(String username, String password, LoginService service) {
        mUsername = username;
        mPassword = password;
        mService = service;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        String url = String.format("https://qiita.com/api/v1/auth?url_name=%s&password=%s", mService.convert(mUsername), mPassword);
        return new HttpPost(url);
    }
}
