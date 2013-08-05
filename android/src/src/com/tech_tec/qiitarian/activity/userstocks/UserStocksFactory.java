package com.tech_tec.qiitarian.activity.userstocks;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.userstocks.FetchLatestUserStocksListener;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.items.Item;

public class UserStocksFactory extends CommandsAbstractFactory {
    
    private UserUrlName mUserUrlName;
    
    public UserStocksFactory(UserUrlName userUrlName) {
        mUserUrlName = userUrlName;
    }

    @Override
    public FetchLatestItemsCommand createFetchLatestItemsCommand(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        return new FetchLatestUserStocksListener(listView, adapter, mUserUrlName);
    }

    @Override
    public FetchMoreItemsCommand createFetchMoreItemsCommand(ListView listView, ArrayAdapter<Item> adapter, LayoutInflater inflater) {
        return null;
    }

}
