package com.tech_tec.qiitarian.fragment.user;

import com.tech_tec.qiitarian.fragment.user.FetchUserAsyncTask.Callback;

public class ErrorResponseHandler implements ResponseHandler {
    
    private Callback mCallback;
    
    public ErrorResponseHandler(Callback callback) {
        mCallback = callback;
    }
    
    @Override
    public void handle() {
        mCallback.onError();
    }
    
}
