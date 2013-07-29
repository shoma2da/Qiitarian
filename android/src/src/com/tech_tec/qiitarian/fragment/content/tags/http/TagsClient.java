package com.tech_tec.qiitarian.fragment.content.tags.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.auth.UrlName;
import com.tech_tec.qiitarian.model.http.ClientBase;

public class TagsClient extends ClientBase {
    
    private UrlName mUrlName;
    
    public TagsClient(UrlName urlName) {
        mUrlName = urlName;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        String url = String.format("/api/v1/users/%s/following_tags", mUrlName.toString());
        return new HttpGet(url);
    }
    
}
