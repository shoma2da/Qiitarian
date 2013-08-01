package com.tech_tec.qiitarian.fragment.list.items;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.FetchTask.Callback;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.model.items.Item;

public class FetchMoreContentOnScrollListener extends FetchMoreItemsCommand {
    
    public FetchMoreContentOnScrollListener(ListView listView, LayoutInflater inflater, ArrayAdapter<Item> adapter) {
        super(listView, inflater, adapter);
    }

    @Override
    protected FetchTask createFetchTask(Callback callback, UiCallback uiCallback) {
        return new FetchItemsAsyncTask(callback, uiCallback);
    }
    
}
