package com.tech_tec.qiitarian.fragment.content.list;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.tech_tec.qiitarian.fragment.content.list.task.FetchItemsAsyncTask;
import com.tech_tec.qiitarian.fragment.content.list.task.SetItemsForListCallback;
import com.tech_tec.qiitarian.model.items.Item;

public class ItemsFragment extends ListFragment {
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        ArrayAdapter<Item> adapter = new ItemArrayAdapter(getActivity());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new GotoDetailOnItemClickListener(getActivity()));
        
        new FetchItemsAsyncTask(new SetItemsForListCallback(getListView())).execute();
    }
    
}
