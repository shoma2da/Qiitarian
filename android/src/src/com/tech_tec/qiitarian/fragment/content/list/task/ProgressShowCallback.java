package com.tech_tec.qiitarian.fragment.content.list.task;

import android.support.v4.app.ListFragment;

import com.tech_tec.qiitarian.fragment.content.list.task.FetchItemsAsyncTask.UiCallback;

public class ProgressShowCallback implements UiCallback {
    
    private ListFragment mListFragment;
    
    public ProgressShowCallback(ListFragment listFragment) {
        mListFragment = listFragment;
    }
    
    @Override
    public void onPostExecute() {
        mListFragment.setListShown(true);
    }
    
    @Override
    public void onPreExecute() {
        mListFragment.setListShown(false);
    }
    
}
