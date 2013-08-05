package com.tech_tec.qiitarian.fragment.list.search;

import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.fragment.list.SetItemsForListCallback;
import com.tech_tec.qiitarian.fragment.search.SearchWord;
import com.tech_tec.qiitarian.model.items.Item;

public class FetchLatestSearchItemsListener extends FetchLatestItemsCommand {
    
    private SearchWord mSearchWord;
    
    public FetchLatestSearchItemsListener(PullToRefreshListView listView, ArrayAdapter<Item> adapter, SearchWord searchWord) {
        super(listView, adapter);
        mSearchWord = searchWord;
    }

    @Override
    protected FetchTask createFetchTask(SetItemsForListCallback callback, UiCallback uiCallback) {
        return new FetchSearchAsyncTask(callback, uiCallback, mSearchWord);
    }

}
