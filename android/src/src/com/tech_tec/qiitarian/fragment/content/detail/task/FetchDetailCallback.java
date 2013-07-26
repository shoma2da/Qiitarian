package com.tech_tec.qiitarian.fragment.content.detail.task;

import android.app.Activity;
import android.widget.Toast;

import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.fragment.content.detail.task.FetchDetailAsyncTask.Callback;

public class FetchDetailCallback implements Callback {
    
    private Activity mActivity;
    
    public FetchDetailCallback(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    public void onSuccess(Detail detail) {
        Toast.makeText(mActivity, detail.toString(), Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void onError() {
        Toast.makeText(mActivity, "通信エラー", Toast.LENGTH_SHORT).show();
    }
}
