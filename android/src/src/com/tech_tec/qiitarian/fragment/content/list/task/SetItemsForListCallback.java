package com.tech_tec.qiitarian.fragment.content.list.task;

import java.util.Iterator;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public class SetItemsForListCallback implements FetchItemsAsyncTask.Callback {
    
    private ListView mListView;
    
    public SetItemsForListCallback(ListView listView) {
        mListView = listView;
    }
    
    @Override
    public void onSuccess(Items items) {
        ArrayAdapter<Item> adapter = (ArrayAdapter<Item>)mListView.getAdapter();
        
        Iterator<Item> iterator = items.getItemIterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            adapter.add(item);
        }
    }

    @Override
    public void onEmptySuccess() {
    }

    @Override
    public void onError() {
    }

}
