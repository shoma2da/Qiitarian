package com.tech_tec.qiitarian.fragment.list;

import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.markupartist.android.widget.PullToRefreshListView.OnRefreshListener;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.model.items.Item;

public abstract class FetchLatestItemsCommand implements OnRefreshListener {
    
    private PullToRefreshListView mListView;
    private ArrayAdapter<Item> mAdapter;
    
    public FetchLatestItemsCommand(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        mListView = listView;
        mAdapter = adapter;
    }
    
    @Override
    public void onRefresh() {
        SetItemsForListCallback callback = new SetItemsForListCallback(mAdapter);
        UiCallback uiCallback = new ProgressShowCallback(mListView);
        createFetchTask(callback, uiCallback).execute(1); //PullToUpdateで更新するのは常に最新の情報
    }
    
    protected abstract FetchTask createFetchTask(SetItemsForListCallback callback, UiCallback uiCallback);
    
}
