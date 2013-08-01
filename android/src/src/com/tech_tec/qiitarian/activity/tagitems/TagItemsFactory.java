package com.tech_tec.qiitarian.activity.tagitems;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.tags.FetchLatestTagItemsListener;
import com.tech_tec.qiitarian.fragment.list.tags.FetchMoreTagItemsListener;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class TagItemsFactory extends CommandsAbstractFactory {
    
    private UrlName mUrlName;
    private LayoutInflater mInflater;
    
    public TagItemsFactory(LayoutInflater inflater, UrlName urlName) {
        mUrlName = urlName;
        mInflater = inflater;
    }
    
    @Override
    public FetchLatestItemsCommand createGetLatestItemsCommand(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        return new FetchLatestTagItemsListener(listView, adapter, mUrlName);
    }

    @Override
    public FetchMoreItemsCommand createFetchMoreItemsCommand(ListView listView, ArrayAdapter<Item> adapter) {
        return new FetchMoreTagItemsListener(listView, mInflater, adapter, mUrlName);
    }

}
