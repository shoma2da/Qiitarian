package com.tech_tec.qiitarian.api;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.http.AndroidHttpClient;

import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.LoginService;

public class ApiAccessor {
    
    public static final String API_BASE = "https://qiita.com/api/v1";
    
    private AndroidHttpClientFactory mHttpClientFactory;
    private JSONObjectFactory mJsonObjectFactory;
    
    public ApiAccessor(AndroidHttpClientFactory httpClientFactory, JSONObjectFactory jsonObjectFactory) {
        mHttpClientFactory = httpClientFactory;
        mJsonObjectFactory = jsonObjectFactory;
    }
    
    public AuthInfo auth(String username, String password, LoginService service) throws ClientProtocolException, IOException, JSONException {
        String url = String.format("%s/auth?url_name=%s&password=%s", API_BASE, service.convert(username), password);
        
        AndroidHttpClient client = mHttpClientFactory.create();
        try {
            HttpResponse response = client.execute(new HttpPost(url));
            JSONObject json = mJsonObjectFactory.create(response);
            return createAuthInfo(response.getStatusLine().getStatusCode(), json, username, service);
        } finally {
            client.close();
        }
    }
    
    private AuthInfo createAuthInfo(int statusCode, JSONObject json, String username, LoginService service) throws JSONException {
        if (statusCode == 200) {
            String token = json.getString("token");
            
            AuthInfo authInfo = new AuthInfo();
            authInfo.setToken(token);
            authInfo.setUsername(username);
            authInfo.setService(service);
            return authInfo;
        } else {
            AuthInfo authInfo = new AuthInfo();
            authInfo.setToken(null);
            authInfo.setUsername(username);
            authInfo.setService(service);
            return authInfo;
        }
    }
    
    public interface AndroidHttpClientFactory {
        AndroidHttpClient create();
    }
    
    public interface JSONObjectFactory {
        JSONObject create(HttpResponse response) throws IOException, JSONException;
    }
}
