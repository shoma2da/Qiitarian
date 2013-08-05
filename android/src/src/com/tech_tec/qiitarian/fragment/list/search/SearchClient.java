package com.tech_tec.qiitarian.fragment.list.search;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.fragment.search.SearchWord;
import com.tech_tec.qiitarian.model.http.ClientBase;

public class SearchClient extends ClientBase {
    
    private SearchWord mSearchWord;
    
    public SearchClient(SearchWord searchWord) {
        mSearchWord = searchWord;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        String url = String.format("https://qiita.com/api/v1/search?q=%s", mSearchWord.toString());
        return new HttpGet(url);
    }
    
}
