package com.tech_tec.qiitarian.fragment.content.detail.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.model.items.http.HttpResponseWrapper;

public class DetailClient {
    
    //TODO ItemsClient, AuthInfoClientと重複しまくり
    public HttpResponseWrapper execute(Uuid uuid, AuthInfo info) throws ClientProtocolException, IOException {
        HttpClient client = createHttpClient();
        HttpUriRequest request = createRequest(uuid, info);
                
        QiitarianLog.d("access to " + request.getURI());
        HttpResponse response = client.execute(request);
        QiitarianLog.d("finish access");
        
        return new HttpResponseWrapper(response);
    }
    
    HttpClient createHttpClient() {
        return new DefaultHttpClient();
    }
    
    HttpUriRequest createRequest(Uuid uuid, AuthInfo authInfo) {
        String url = String.format("https://qiita.com/api/v1/items/%s?token=", uuid.toString(), authInfo.getTokenStr());
        return new HttpGet(url);
    }

}
