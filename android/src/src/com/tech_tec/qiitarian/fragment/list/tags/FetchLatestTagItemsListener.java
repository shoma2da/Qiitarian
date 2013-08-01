package com.tech_tec.qiitarian.fragment.list.tags;

import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.fragment.list.SetItemsForListCallback;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class FetchLatestTagItemsListener extends FetchLatestItemsCommand{
    
    private UrlName mUrlName;
    
    public FetchLatestTagItemsListener(PullToRefreshListView listView, ArrayAdapter<Item> adapter, UrlName urlName) {
        super(listView, adapter);
        mUrlName = urlName;
    }

    @Override
    protected FetchTask createFetchTask(SetItemsForListCallback callback, UiCallback uiCallback) {
        return new FetchTagItemsAsyncTask(callback, uiCallback, mUrlName);
    }

}
