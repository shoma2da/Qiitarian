package com.tech_tec.qiitarian.task.detail;

import android.os.AsyncTask;

import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.items.Uuid;

//TODO 全体的にFetchItemsAsyncTaskのコピー
public class FetchDetailAsyncTask extends AsyncTask<Void, Void, Detail> {
    
    private Uuid mUuid;
    private AuthInfo mAuthInfo;
    private Callback mCallback;
    
    public FetchDetailAsyncTask(Uuid uuid, AuthInfo authInfo, Callback callback) {
        mCallback = callback;
        mAuthInfo = authInfo;
        mUuid = uuid;
    }
    
    @Override
    protected Detail doInBackground(Void... params) {
        try {
            DetailFetcher fetcher = new DetailFetcher();
            return fetcher.fetch(mUuid, mAuthInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    protected void onPostExecute(Detail result) {
        super.onPostExecute(result);
        
        if (result == null) {
            mCallback.onError();
            return;
        }
        mCallback.onSuccess(result);
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCallback.onPreExecute();
    }
    
    public interface Callback {
        void onPreExecute();
        void onSuccess(Detail detail);
        void onError();
    }
}
