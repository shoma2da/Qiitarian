package com.tech_tec.qiitarian.fragment.content.list;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.content.list.task.FetchItemsAsyncTask;
import com.tech_tec.qiitarian.fragment.content.list.task.SetItemsForListCallback;

public class ItemsFragment extends ListFragment {
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.listraw_item, R.id.text_item_title);
        setListAdapter(adapter);
        
        new FetchItemsAsyncTask(new SetItemsForListCallback(getListView())).execute();
    }
    
}
