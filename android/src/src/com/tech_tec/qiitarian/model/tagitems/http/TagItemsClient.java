package com.tech_tec.qiitarian.model.tagitems.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.http.ClientBase;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class TagItemsClient extends ClientBase {
    
    private int mPage;
    private UrlName mUrlName;
    
    public TagItemsClient(int page, UrlName name) {
        mPage = page;
        mUrlName = name;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        return new HttpGet(String.format("https://qiita.com/api/v1/tags/%s/items?page=%d", mUrlName.toString(), mPage));
    }
    
    
}
