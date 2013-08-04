package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.widget.Toast;

import com.tech_tec.qiitarian.fragment.user.FetchUserAsyncTask.Callback;
import com.tech_tec.qiitarian.model.user.User;

public class FetchUserCallback implements Callback {
    
    private Context mContext;
    private ProgressManager mProgressManager;
    
    public FetchUserCallback(Context context) {
        mContext = context;
        mProgressManager = new ProgressManager(context);
    }
    
    @Override
    public void onPreExecute() {
        mProgressManager.show();
    }

    @Override
    public void onSuccess(User user) {
        Toast.makeText(mContext, "get user information " + user.getDescription(), Toast.LENGTH_SHORT).show();
        mProgressManager.dismiss();
    }

    @Override
    public void onError() {
        mProgressManager.dismiss();
    }

}
