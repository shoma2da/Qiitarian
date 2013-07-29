package com.tech_tec.qiitarian.model.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tech_tec.qiitarian.QiitarianLog;

public class SendRequestStrategy {
    
    public HttpResponseWrapper execute(HttpUriRequest request) throws ClientProtocolException, IOException {
        HttpClient client = createHttpClient();
                
        QiitarianLog.d("access to " + request.getMethod() + ":" + request.getURI());
        HttpResponse response = client.execute(request);
        QiitarianLog.d("finish access");
        
        return new HttpResponseWrapper(response);
    }
    
    HttpClient createHttpClient() {
        return new DefaultHttpClient();
    }
    
}
