package com.tech_tec.qiitarian.activity.usersitem;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.useritems.FetchMoreUserItemsListener;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.items.Item;

public class CommandsFactoryImpl extends CommandsAbstractFactory {
    
    private UserUrlName mUserUrlName;
    
    public CommandsFactoryImpl(UserUrlName userUrlName) {
        mUserUrlName = userUrlName;
    }
    
    @Override
    public FetchLatestItemsCommand createFetchLatestItemsCommand(PullToRefreshListView listView, ArrayAdapter<Item> adapter) {
        return new FetchLatestUserItemsListener(listView, adapter, mUserUrlName);
    }

    @Override
    public FetchMoreItemsCommand createFetchMoreItemsCommand(ListView listView, ArrayAdapter<Item> adapter, LayoutInflater inflater) {
        return new FetchMoreUserItemsListener(listView, inflater, adapter, mUserUrlName);
    }

}
