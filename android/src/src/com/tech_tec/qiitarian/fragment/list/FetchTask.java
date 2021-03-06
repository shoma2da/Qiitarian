package com.tech_tec.qiitarian.fragment.list;

import android.os.AsyncTask;

import com.tech_tec.qiitarian.model.items.Items;

public abstract class FetchTask extends AsyncTask<Integer, Void, Items> {
    
    private Callback mCallback;
    private UiCallback mUiCallback;
    
    public FetchTask(Callback callback, UiCallback uiCallback) {
        mCallback = callback;
        mUiCallback = uiCallback;
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mUiCallback.onPreExecute();
    }
    
    @Override
    protected Items doInBackground(Integer... params) {
        if (params.length == 0) {
            return null;
        }
        
        int page = params[0];
        
        try {
            ItemsFetcher fetcher = createItemsFetcher(page);
            return fetcher.fetch(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    protected abstract ItemsFetcher createItemsFetcher(int page);
    
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
