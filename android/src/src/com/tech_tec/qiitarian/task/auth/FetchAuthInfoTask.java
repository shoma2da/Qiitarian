package com.tech_tec.qiitarian.task.auth;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.content.Context;
import android.os.AsyncTask;

import com.tech_tec.qiitarian.fragment.user.ProgressManager;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.LoginService;

public class FetchAuthInfoTask extends AsyncTask<Void, Void, AuthInfo> {
    
    private String mUsername;
    private String mPassword;
    private LoginService mService;
    private Callback mCallback;

    private ProgressManager mProgressManager;
    
    public FetchAuthInfoTask(String username, String password, LoginService service, Callback callback, Context context) {
        mUsername = username;
        mPassword = password;
        mService = service;
        mCallback = callback;
        mProgressManager = new ProgressManager(context);
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressManager.show();
    }
    
    @Override
    protected AuthInfo doInBackground(Void... params) {
        try {
            AuthInfoFetcher fetcher = new AuthInfoFetcher();
            return fetcher.fetch(mUsername, mPassword, mService);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    protected void onPostExecute(AuthInfo result) {
        super.onPostExecute(result);
        
        if (result == null) {
            mCallback.onError();
            return;
        }
        if (result == AuthInfo.NULL) {
            mCallback.onEmptySuccess();
            return;
        }
        mCallback.onSuccess(result);
        
        mProgressManager.dismiss();
    }
    
    public interface Callback {
        void onSuccess(AuthInfo authInfo);
        void onEmptySuccess();
        void onError();
    }
}
