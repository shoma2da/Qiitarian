package com.tech_tec.qiitarian.fragment.list.search;

import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.ItemsFetcher;
import com.tech_tec.qiitarian.fragment.search.SearchWord;

public class FetchSearchAsyncTask extends FetchTask {
    
    private SearchWord mSearchWord;
    
    public FetchSearchAsyncTask(Callback callback, UiCallback uiCallback, SearchWord searchWord) {
        super(callback, uiCallback);
        mSearchWord = searchWord;
    }

    @Override
    protected ItemsFetcher createItemsFetcher(int page) {
        return new ItemsFetcher(new SearchClient(mSearchWord, page));
    }

}
