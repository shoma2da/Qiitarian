package com.tech_tec.qiitarian.model.tags.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import android.annotation.SuppressLint;

import com.tech_tec.qiitarian.model.auth.UrlName;
import com.tech_tec.qiitarian.model.http.ClientBase;

public class TagsClient extends ClientBase {
    
    public static final int PER_PAGE = 100; //TODO とりあえず100件取得して、ページネーションしない
    
    private UrlName mUrlName;
    
    public TagsClient(UrlName urlName) {
        mUrlName = urlName;
    }
    
    @Override @SuppressLint("DefaultLocale")
    protected HttpUriRequest createRequest() {
        String url = String.format("https://qiita.com/api/v1/users/%s/following_tags?per_page=%d", mUrlName.toString(), PER_PAGE);
        return new HttpGet(url);
    }
    
}
