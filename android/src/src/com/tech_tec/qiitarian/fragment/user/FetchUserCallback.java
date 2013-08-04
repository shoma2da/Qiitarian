package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.widget.Toast;

import com.tech_tec.qiitarian.fragment.user.FetchUserAsyncTask.Callback;
import com.tech_tec.qiitarian.model.user.User;

public class FetchUserCallback implements Callback {
    
    private Context mContext;
    
    public FetchUserCallback(Context context) {
        mContext = context;
    }
    
    @Override
    public void onPreExecute() {
    }

    @Override
    public void onSuccess(User user) {
        Toast.makeText(mContext, "get user information " + user.getDescription(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
    }

}
