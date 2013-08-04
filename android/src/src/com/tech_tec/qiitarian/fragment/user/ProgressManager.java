package com.tech_tec.qiitarian.fragment.user;

import com.tech_tec.qiitarian.R;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressManager {
    
    private ProgressDialog mDialog;
    
    public ProgressManager(Context context) {
        mDialog = new ProgressDialog(context);
        mDialog.setMessage(context.getString(R.string.wait_message));
    }
    
    public void show() {
        mDialog.show();
    }
    
    public void dismiss() {
        mDialog.dismiss();
    }
    
}
