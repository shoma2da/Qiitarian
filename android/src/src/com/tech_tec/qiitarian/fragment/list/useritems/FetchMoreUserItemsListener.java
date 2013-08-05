package com.tech_tec.qiitarian.fragment.list.useritems;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tech_tec.qiitarian.fragment.list.FetchMoreItemsCommand;
import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.FetchTask.Callback;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.items.Item;

public class FetchMoreUserItemsListener extends FetchMoreItemsCommand {
    
    private UserUrlName mUserUrlName;
    
    public FetchMoreUserItemsListener(ListView listView, LayoutInflater inflater, ArrayAdapter<Item> adapter, UserUrlName userUrlName) {
        super(listView, inflater, adapter);
        mUserUrlName = userUrlName;
    }

    @Override
    protected FetchTask createFetchTask(Callback callback, UiCallback uiCallback) {
        return new FetchUserItemsAsyncTask(callback, uiCallback, mUserUrlName);
    }

}
