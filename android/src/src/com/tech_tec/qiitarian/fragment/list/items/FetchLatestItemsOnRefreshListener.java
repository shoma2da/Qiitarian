package com.tech_tec.qiitarian.fragment.list.items;

import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.SetItemsForListCallback;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.model.items.Item;

public class FetchLatestItemsOnRefreshListener extends FetchLatestItemsCommand {
    
    public FetchLatestItemsOnRefreshListener(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        super(listView, adapter);
    }

    @Override
    protected FetchTask createFetchTask(SetItemsForListCallback callback, UiCallback uiCallback) {
        return new FetchItemsAsyncTask(callback, uiCallback);
    }
    
}
