package com.tech_tec.qiitarian.fragment.content.detail.task;

import android.view.View;
import android.widget.Toast;

import com.tech_tec.qiitarian.fragment.content.detail.task.FetchDetailAsyncTask.Callback;
import com.tech_tec.qiitarian.fragment.content.detail.ui.DetailSetter;
import com.tech_tec.qiitarian.model.detail.Detail;

public class FetchDetailCallback implements Callback {
    
    private View mView;
    
    public FetchDetailCallback(View view) {
        mView = view;
    }
    
    @Override
    public void onSuccess(Detail detail) {
        DetailSetter setter = new DetailSetter(detail, mView);
        setter.view();
    }
    
    @Override
    public void onError() {
        Toast.makeText(mView.getContext(), "通信エラー", Toast.LENGTH_SHORT).show();
    }
}
