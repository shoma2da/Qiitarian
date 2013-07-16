package com.tech_tec.qiitarian.fragment.content.list.task;

import android.os.AsyncTask;

import com.tech_tec.qiitarian.model.items.Items;

public class FetchItemsResponseAsyncTask extends AsyncTask<Void, Void, Items> {
    
    private Callback mCallback;
    
    public FetchItemsResponseAsyncTask(Callback callback) {
        mCallback = callback;
    }
    
    @Override
    protected Items doInBackground(Void... params) {
        try {
            ItemsFetcher fetcher = createItemsFetcher();
            return fetcher.fetch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    ItemsFetcher createItemsFetcher() {
        return new ItemsFetcher();
    }
    
    @Override
    protected void onPostExecute(Items result) {
        super.onPostExecute(result);
        
        if (result == null) {
            mCallback.onError();
            return;
        }
        
        if (result.isEmpty()) {
            mCallback.onFailure();
        } else {
            mCallback.onSuccess();
        }
    }
    
    public interface Callback {
        void onSuccess();
        void onFailure();
        void onError();
    }
}
