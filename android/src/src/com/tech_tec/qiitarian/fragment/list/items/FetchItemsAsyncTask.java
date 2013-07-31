package com.tech_tec.qiitarian.fragment.list.items;

import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.ItemsFetcher;
import com.tech_tec.qiitarian.model.items.http.ItemsClient;

public class FetchItemsAsyncTask extends FetchTask {

    public FetchItemsAsyncTask(Callback callback, UiCallback uiCallback) {
        super(callback, uiCallback);
    }

    @Override
    protected ItemsFetcher createItemsFetcher(int page) {
        return new ItemsFetcher(new ItemsClient(page));
    }
    
}
