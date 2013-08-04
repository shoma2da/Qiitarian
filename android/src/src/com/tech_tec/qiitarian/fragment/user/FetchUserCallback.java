package com.tech_tec.qiitarian.fragment.user;

import android.content.Context;
import android.view.View;

import com.tech_tec.qiitarian.fragment.user.FetchUserAsyncTask.Callback;
import com.tech_tec.qiitarian.model.user.User;

public class FetchUserCallback implements Callback {
    
    private ProgressManager mProgressManager;
    private UiSetter mUiSetter;
    
    public FetchUserCallback(Context context, View view) {
        mProgressManager = new ProgressManager(context);
        mUiSetter = new UiSetter(view);
    }
    
    @Override
    public void onPreExecute() {
        mProgressManager.show();
    }

    @Override
    public void onSuccess(User user) {
        mProgressManager.dismiss();
        mUiSetter.showView(user);
    }

    @Override
    public void onError() {
        mProgressManager.dismiss();
        mUiSetter.showErrorView();
    }

}
