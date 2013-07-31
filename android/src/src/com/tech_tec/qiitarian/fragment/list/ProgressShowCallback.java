package com.tech_tec.qiitarian.fragment.list;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;

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
