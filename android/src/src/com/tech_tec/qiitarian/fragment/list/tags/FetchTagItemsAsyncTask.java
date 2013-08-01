package com.tech_tec.qiitarian.fragment.list.tags;

import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.ItemsFetcher;
import com.tech_tec.qiitarian.model.tagitems.http.TagItemsClient;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class FetchTagItemsAsyncTask extends FetchTask {
    
    private UrlName mUrlName;
    
    public FetchTagItemsAsyncTask(Callback callback, UiCallback uiCallback, UrlName urlName) {
        super(callback, uiCallback);
        mUrlName = urlName;
    }
    
    @Override
    protected ItemsFetcher createItemsFetcher(int page) {
        return new ItemsFetcher(new TagItemsClient(page, mUrlName));
    }

}
