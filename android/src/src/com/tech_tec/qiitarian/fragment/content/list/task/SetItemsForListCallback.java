package com.tech_tec.qiitarian.fragment.content.list.task;

import java.util.Iterator;

import android.widget.ArrayAdapter;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public class SetItemsForListCallback implements FetchItemsAsyncTask.Callback {
    
    private ArrayAdapter<Item> mAdapter;
    
    public SetItemsForListCallback(ArrayAdapter<Item> adapter) {
        mAdapter = adapter;
    }
    
    @Override
    public void onSuccess(Items items) {
        Iterator<Item> iterator = items.getItemIterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            mAdapter.add(item);
        }
    }

    @Override
    public void onEmptySuccess() {
    }

    @Override
    public void onError() {
    }

}
