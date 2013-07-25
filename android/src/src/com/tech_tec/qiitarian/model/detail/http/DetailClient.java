package com.tech_tec.qiitarian.model.detail.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.http.ClientBase;
import com.tech_tec.qiitarian.model.items.Uuid;

public class DetailClient extends ClientBase {
    
    private Uuid mUuid;
    private AuthInfo mAuthInfo;
    
    public DetailClient(Uuid uuid, AuthInfo info) {
        mUuid = uuid;
        mAuthInfo = info;
    }
    
    protected HttpUriRequest createRequest() {
        String url = String.format("https://qiita.com/api/v1/items/%s?token=%s", mUuid.toString(), mAuthInfo.getTokenStr());
        return new HttpGet(url);
    }

}
