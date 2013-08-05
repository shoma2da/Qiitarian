package com.tech_tec.qiitarian.task.detail;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Toast;

import com.tech_tec.qiitarian.fragment.detail.DetailSetter;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.task.detail.FetchDetailAsyncTask.Callback;

public class FetchDetailCallback implements Callback {
    
    private View mView;
    private ProgressDialog mDialog;
    
    public FetchDetailCallback(View view) {
        mView = view;
    }
    
    @Override
    public void onSuccess(Detail detail) {
        DetailSetter setter = new DetailSetter(detail, mView, mView.getContext());
        setter.view();
        mDialog.dismiss();
    }
    
    @Override
    public void onError() {
        Toast.makeText(mView.getContext(), "通信エラー", Toast.LENGTH_SHORT).show();
        mDialog.dismiss();
    }

    @Override
    public void onPreExecute() {
        mDialog = new ProgressDialog(mView.getContext());
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setMessage("読込中...");
        mDialog.show();
    }
}
