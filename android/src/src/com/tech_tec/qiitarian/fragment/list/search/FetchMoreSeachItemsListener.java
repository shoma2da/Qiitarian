package com.tech_tec.qiitarian.fragment.list.search;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.FetchTask.Callback;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.fragment.search.SearchWord;
import com.tech_tec.qiitarian.model.items.Item;

public class FetchMoreSeachItemsListener extends FetchMoreItemsCommand {
    
    private SearchWord mSearchWord;
    
    public FetchMoreSeachItemsListener(ListView listView, LayoutInflater inflater, ArrayAdapter<Item> adapter, SearchWord searchWord) {
        super(listView, inflater, adapter);
        mSearchWord = searchWord;
    }

    @Override
    protected FetchTask createFetchTask(Callback callback, UiCallback uiCallback) {
        return new FetchSearchAsyncTask(callback, uiCallback, mSearchWord);
    }

}
