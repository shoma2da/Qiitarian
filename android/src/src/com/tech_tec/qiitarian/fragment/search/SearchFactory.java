package com.tech_tec.qiitarian.fragment.search;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.search.FetchLatestSearchItemsListener;
import com.tech_tec.qiitarian.fragment.list.search.FetchMoreSeachItemsListener;
import com.tech_tec.qiitarian.model.items.Item;

public class SearchFactory extends CommandsAbstractFactory {
    
    private SearchWord mSearchWord;
    
    public SearchFactory(SearchWord searchWord) {
        mSearchWord = searchWord;
    }
    
    @Override
    public FetchLatestItemsCommand createFetchLatestItemsCommand(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        return new FetchLatestSearchItemsListener(listView, adapter, mSearchWord);
    }

    @Override
    public FetchMoreItemsCommand createFetchMoreItemsCommand(ListView listView, ArrayAdapter<Item> adapter, LayoutInflater inflater) {
        return new FetchMoreSeachItemsListener(listView, inflater, adapter, mSearchWord);
    }

}
