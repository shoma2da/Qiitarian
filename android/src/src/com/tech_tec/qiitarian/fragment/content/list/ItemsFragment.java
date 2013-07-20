package com.tech_tec.qiitarian.fragment.content.list;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.tech_tec.qiitarian.fragment.content.list.task.FetchItemsAsyncTask;
import com.tech_tec.qiitarian.fragment.content.list.task.SetItemsForListCallback;

public class ItemsFragment extends ListFragment {
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        
        new FetchItemsAsyncTask(new SetItemsForListCallback(getListView())).execute();
    }
    
}
