package com.tech_tec.qiitarian.model.http.stock;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.http.ClientBase;

public class PutStockClient extends ClientBase {
    
    private Detail mDetail;
    private AuthInfo mAuthInfo;
    
    public PutStockClient(AuthInfo authInfo, Detail detail) {
        mAuthInfo = authInfo;
        mDetail = detail;
    }
    
    @Override
    protected HttpUriRequest createRequest() {
        String url = String.format("https://qiita.com/api/v1/items/%s/stock?token=%s", mDetail.getUuidStr(), mAuthInfo.getTokenStr());
        return new HttpPut(url);
    }
    
}
