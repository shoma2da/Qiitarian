package com.tech_tec.qiitarian.fragment.list;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.model.items.Item;

public abstract class CommandsAbstractFactory {
    
    public abstract GetLatestItemsCommand createGetLatestItemsCommand(PullToRefreshListView listView, ArrayAdapter<Item> adapter);
    public abstract FetchMoreItemsCommand createFetchMoreItemsCommand(ListView listView, ArrayAdapter<Item> adapter);
    
}
