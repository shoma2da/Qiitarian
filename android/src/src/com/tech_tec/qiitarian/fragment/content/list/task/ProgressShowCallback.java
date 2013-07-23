package com.tech_tec.qiitarian.fragment.content.list.task;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.content.list.task.FetchItemsAsyncTask.UiCallback;

public class ProgressShowCallback implements UiCallback {
    
    private PullToRefreshListView mListView;
    
    public ProgressShowCallback(PullToRefreshListView listView) {
        mListView = listView;
    }
    
    @Override
    public void onPreExecute() {
        //何もしない
    }
    
    @Override
    public void onPostExecute() {
        mListView.onRefreshComplete();
    }
    
}
