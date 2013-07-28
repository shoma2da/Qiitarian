package com.tech_tec.qiitarian.fragment.content.list;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.tech_tec.qiitarian.R;

public class FetchMoreContentOnScrollListener implements OnScrollListener {
    
    private ListView mListView;
    private ListAdapter mAdapter;
    private LayoutInflater mInflater;
    
    public FetchMoreContentOnScrollListener(ListView listView, LayoutInflater inflater, ListAdapter adapter) {
        mListView = listView;
        mInflater = inflater;
        mAdapter = adapter;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mAdapter.getCount() == 0 || mListView.getFooterViewsCount() != 0) {
            return;
        }
        
        if (firstVisibleItem + visibleItemCount == totalItemCount) {//リストの最後尾を表示したら
            View footer = mInflater.inflate(R.layout.layout_list_footer, null);
            mListView.addFooterView(footer);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //なにもしない
    }
    
}
