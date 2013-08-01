package com.tech_tec.qiitarian.fragment.list.tags;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.FetchTask.Callback;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class FetchMoreTagItemsListener extends FetchMoreItemsCommand {
    
    private UrlName mUrlName;
    
    public FetchMoreTagItemsListener(ListView listView, LayoutInflater inflater, ArrayAdapter<Item> adapter, UrlName urlName) {
        super(listView, inflater, adapter);
        mUrlName = urlName;
    }
    
    @Override
    protected FetchTask createFetchTask(Callback callback, UiCallback uiCallback) {
        return new FetchTagItemsAsyncTask(callback, uiCallback, mUrlName);
    }
    
}
