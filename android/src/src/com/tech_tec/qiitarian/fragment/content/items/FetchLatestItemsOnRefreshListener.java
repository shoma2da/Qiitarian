package com.tech_tec.qiitarian.fragment.content.items;

import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.markupartist.android.widget.PullToRefreshListView.OnRefreshListener;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.task.list.FetchItemsAsyncTask;
import com.tech_tec.qiitarian.task.list.FetchItemsAsyncTask.UiCallback;
import com.tech_tec.qiitarian.task.list.ProgressShowCallback;
import com.tech_tec.qiitarian.task.list.SetItemsForListCallback;

public class FetchLatestItemsOnRefreshListener implements OnRefreshListener {
    
    private PullToRefreshListView mListView;
    private ArrayAdapter<Item> mAdapter;
    
    public FetchLatestItemsOnRefreshListener(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        mListView = listView;
        mAdapter = adapter;
    }
    
    @Override
    public void onRefresh() {
        SetItemsForListCallback callback = new SetItemsForListCallback(mAdapter);
        UiCallback uiCallback = new ProgressShowCallback(mListView);
        new FetchItemsAsyncTask(callback, uiCallback).execute(1); //PullToUpdateで更新するのは常に最新の情報
    }

}
