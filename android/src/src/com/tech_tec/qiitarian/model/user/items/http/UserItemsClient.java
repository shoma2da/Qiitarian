package com.tech_tec.qiitarian.model.user.items.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.http.ClientBase;

public class UserItemsClient extends ClientBase {
    
    private int mPage;
    private UserUrlName mUserUrlName;
    
    public UserItemsClient(int page, UserUrlName userUrlName) {
        mPage = page;
        mUserUrlName = userUrlName;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        return new HttpGet(String.format("https://qiita.com/api/v1/users/%s/items?page=%d", mUserUrlName.toString(), mPage));
    }

}
