package com.tech_tec.qiitarian.fragment.user;

import com.tech_tec.qiitarian.fragment.user.FetchUserAsyncTask.Callback;
import com.tech_tec.qiitarian.model.user.User;

public class SuccessResponseHandler implements ResponseHandler {
    
    private Callback mCallback;
    private User mUser;
    
    public SuccessResponseHandler(Callback callback, User user) {
        mCallback = callback;
        mUser = user;
    }
    
    @Override
    public void handle() {
        mCallback.onSuccess(mUser);
    }
    
}
