package com.tech_tec.qiitarian.task.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.tech_tec.qiitarian.fragment.content.detail.ui.DetailSetter;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.task.detail.FetchDetailAsyncTask.Callback;

public class FetchDetailCallback implements Callback {
    
    private View mView;
    
    public FetchDetailCallback(View view) {
        mView = view;
    }
    
    @Override
    public void onSuccess(Detail detail) {
        LayoutInflater inflater = LayoutInflater.from(mView.getContext());
        DetailSetter setter = new DetailSetter(detail, mView, inflater);
        setter.view();
    }
    
    @Override
    public void onError() {
        Toast.makeText(mView.getContext(), "通信エラー", Toast.LENGTH_SHORT).show();
    }
}
