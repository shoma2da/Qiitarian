package com.tech_tec.qiitarian.model.auth.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.auth.LoginService;
import com.tech_tec.qiitarian.model.items.http.HttpResponseWrapper;

public class AuthInfoClient {
    
    //TODO ItemsClientと重複しまくり
    public HttpResponseWrapper execute(String username, String password, LoginService service) throws ClientProtocolException, IOException {
        HttpClient client = createHttpClient();
        HttpUriRequest request = createRequest(username, password, service);
                
        QiitarianLog.d("access to " + request.getURI());
        HttpResponse response = client.execute(request);
        QiitarianLog.d("finish access");
        
        return new HttpResponseWrapper(response);
    }
    
    HttpClient createHttpClient() {
        return new DefaultHttpClient();
    }
    
    HttpUriRequest createRequest(String username, String password, LoginService service) {
        String url = String.format("https://qiita.com/api/v1/auth?url_name=%s&password=%s", service.convert(username), password);
        return new HttpPost(url);
    }
}
