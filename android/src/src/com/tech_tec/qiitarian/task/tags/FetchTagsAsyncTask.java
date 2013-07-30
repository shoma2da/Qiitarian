package com.tech_tec.qiitarian.task.tags;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.os.AsyncTask;

import com.tech_tec.qiitarian.model.auth.UrlName;
import com.tech_tec.qiitarian.model.tags.Tags;

public class FetchTagsAsyncTask extends AsyncTask<Void, Void, Tags> {
    
    private UrlName mUrlName;
    private Callback mCallback;
    
    public FetchTagsAsyncTask(UrlName urlName, Callback callback) {
        mUrlName = urlName;
        mCallback = callback;
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCallback.onPreExecute();
    }
    
    @Override
    protected Tags doInBackground(Void... params) {
        TagsFetcher fetcher = new TagsFetcher();
        try {
            return fetcher.fetch(mUrlName);
        }
        catch (ClientProtocolException e) { e.printStackTrace(); return null; }
        catch (ParseException          e) { e.printStackTrace(); return null; }
        catch (IOException             e) { e.printStackTrace(); return null; }
        catch (JSONException           e) { e.printStackTrace(); return null; }
    }
    
    @Override
    protected void onPostExecute(Tags result) {
        super.onPostExecute(result);
        
        if (result == null) {
            mCallback.onError();
            return;
        }
        if (result.isEmpty()) {
            mCallback.onEmpty();
            return;
        }
        mCallback.onSuccess(result);
    }
    
    public interface Callback {
        void onPreExecute();
        void onSuccess(Tags tags);
        void onEmpty();
        void onError();
    }
}
