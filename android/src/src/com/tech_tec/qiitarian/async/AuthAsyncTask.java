package com.tech_tec.qiitarian.async;

import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.tech_tec.qiitarian.api.ApiAccessor;
import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.LoginService;

public class AuthAsyncTask extends AsyncTask<String, Void, AuthInfo> {
    
    private ArrayList<OnAuthListener> mListeners = new ArrayList<OnAuthListener>();
    private ApiAccessor mApiAccessor;
    private Context mContext;
    
    public AuthAsyncTask(Context context, ApiAccessor apiAccessor) {
        mApiAccessor = apiAccessor;
        mContext = context;
    }
    
    public interface OnAuthListener {
        void onAuth(boolean hasError, AuthInfo authInfo, boolean isAuthed);
    }
    
    public void addOnAuthListener(OnAuthListener listener) {
        mListeners.add(listener);
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(mContext, "onPreExecute", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected AuthInfo doInBackground(String... params) {
        String username = params[0];
        String password = params[1];
        LoginService service = LoginService.getByName(params[2]);
        
        try {
            return mApiAccessor.auth(username, password, service);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    protected void onPostExecute(AuthInfo result) {
        Toast.makeText(mContext, "onPostExecute", Toast.LENGTH_SHORT).show();
        if (result == null) {
            callListeners(true, null, false);
        } else if (result.getToken() == null || result.getToken().length() == 0) {
            callListeners(false, result, false);
        } else {
            callListeners(false, result, true);
        }
    }
    
    private void callListeners(boolean hasError, AuthInfo authInfo, boolean isAuthed) {
        for (OnAuthListener listener : mListeners) {
            listener.onAuth(hasError, authInfo, isAuthed);
        }
    }
}
