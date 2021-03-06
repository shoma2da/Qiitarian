package com.tech_tec.qiitarian.activity.home;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.items.FetchLatestItemsListener;
import com.tech_tec.qiitarian.fragment.list.items.FetchMoreItemsListener;
import com.tech_tec.qiitarian.model.items.Item;

public class DefaultCommandsAbstractFactory extends CommandsAbstractFactory {
    
    @Override
    public FetchLatestItemsCommand createFetchLatestItemsCommand(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        return new FetchLatestItemsListener(listView, adapter);
    }

    @Override
    public FetchMoreItemsCommand createFetchMoreItemsCommand(ListView listView, ArrayAdapter<Item> adapter, LayoutInflater inflater) {
        return new FetchMoreItemsListener(listView, inflater, adapter);
    }

}
