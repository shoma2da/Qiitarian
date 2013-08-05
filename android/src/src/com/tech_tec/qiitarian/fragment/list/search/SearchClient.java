package com.tech_tec.qiitarian.fragment.list.search;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import android.annotation.SuppressLint;
import com.tech_tec.qiitarian.fragment.search.SearchWord;
import com.tech_tec.qiitarian.model.http.ClientBase;

public class SearchClient extends ClientBase {
    
    private SearchWord mSearchWord;
    private int mPage;
    
    public SearchClient(SearchWord searchWord, int page) {
        mSearchWord = searchWord;
        mPage = page;
    }
    
    @Override @SuppressLint("DefaultLocale")
    protected HttpUriRequest createRequest() {
        String url = String.format("https://qiita.com/api/v1/search?page=%d&q=", mPage);
        try {
            String param = mSearchWord.toUrlString();
            url += param;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new HttpGet(url);
    }
    
}
