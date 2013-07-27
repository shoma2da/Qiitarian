package com.tech_tec.qiitarian.fragment.content.detail.ui;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.http.stock.PutStockClient;

import android.view.View;
import android.view.View.OnClickListener;

class PutStockOnClickListener implements OnClickListener, Runnable {
    
    private AuthInfo mAuthInfo;
    private Detail mDetail;
    
    public PutStockOnClickListener(AuthInfo authInfo, Detail detail) {
        mAuthInfo = authInfo;
        mDetail = detail;
    }
    
    @Override
    public void onClick(View v) {
        start();
    }
    
    void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            new PutStockClient(mAuthInfo, mDetail).execute();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
