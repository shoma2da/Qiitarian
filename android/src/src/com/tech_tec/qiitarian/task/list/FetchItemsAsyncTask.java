package com.tech_tec.qiitarian.task.list;

import android.os.AsyncTask;

import com.tech_tec.qiitarian.model.items.Items;

public class FetchItemsAsyncTask extends AsyncTask<Void, Void, Items> {
    
    private Callback mCallback;
    private UiCallback mUiCallback;
    
    public FetchItemsAsyncTask(Callback callback, UiCallback uiCallback) {
        mCallback = callback;
        mUiCallback = uiCallback;
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mUiCallback.onPreExecute();
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
        mUiCallback.onPostExecute();
        
        if (result == null) {
            mCallback.onError();
            return;
        }
        if (result.isEmpty()) {
            mCallback.onEmptySuccess();
            return;
        }
        
        mCallback.onSuccess(result);
    }
    
    public interface Callback {
        void onSuccess(Items items);
        void onEmptySuccess();
        void onError();
    }
    
    public interface UiCallback {
        void onPostExecute();
        void onPreExecute();
    }
}
