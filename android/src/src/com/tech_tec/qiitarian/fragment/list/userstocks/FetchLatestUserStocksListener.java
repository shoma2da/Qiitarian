package com.tech_tec.qiitarian.fragment.list.userstocks;

import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.FetchLatestItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.fragment.list.SetItemsForListCallback;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.items.Item;

public class FetchLatestUserStocksListener extends FetchLatestItemsCommand {
    
    private UserUrlName mUserUrlName;
    
    public FetchLatestUserStocksListener(PullToRefreshListView listView, ArrayAdapter<Item> adapter, UserUrlName userUrlName) {
        super(listView, adapter);
        mUserUrlName = userUrlName;
    }

    @Override
    protected FetchTask createFetchTask(SetItemsForListCallback callback, UiCallback uiCallback) {
        return new FetchUserStocksAsyncTask(callback, uiCallback, mUserUrlName);
    }

}
