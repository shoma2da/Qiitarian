package com.tech_tec.qiitarian.fragment.content.detail.ui;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.http.stock.DeleteStockClient;
import com.tech_tec.qiitarian.model.http.stock.PutStockClient;

class PutStockOnClickListener implements OnCheckedChangeListener {
    
    private AuthInfo mAuthInfo;
    private Detail mDetail;
    
    public PutStockOnClickListener(AuthInfo authInfo, Detail detail) {
        mAuthInfo = authInfo;
        mDetail = detail;
    }
    
    void start(Runnable runnable) {
        new Thread(runnable).start();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        QiitarianLog.d("click button");
        start(createPutStockRunnable(isChecked));
    }
    
    private Runnable createPutStockRunnable(final boolean isChecked) {
        return new Runnable() {
            @Override
            public void run() {
                if (isChecked) {
                    sendPutStockRequest();
                } else {
                    sendDeleteStockRequest();
                }
            }
        };
    }
    
    private void sendPutStockRequest() {
        try {
            new PutStockClient(mAuthInfo, mDetail).execute();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void sendDeleteStockRequest() {
        try {
            new DeleteStockClient(mAuthInfo, mDetail).execute();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
