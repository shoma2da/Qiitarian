package com.tech_tec.qiitarian.api;

import java.io.ByteArrayOutputStream;
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
    
    private String mUserAgent;
    
    public ApiAccessor(String userAagent) {
        mUserAgent = userAagent;
    }
    
    public AuthInfo auth(String username, String password, LoginService service) throws ClientProtocolException, IOException, JSONException {
        String url = String.format("%s/auth?url_name=%s&password=%s", API_BASE, service.convert(username), password);
        
        AndroidHttpClient client = AndroidHttpClient.newInstance(mUserAgent);
        try {
            HttpResponse response = client.execute(new HttpPost(url));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            response.getEntity().writeTo(outputStream);
            String rawJson = outputStream.toString();
            outputStream.close();
            
            JSONObject json = new JSONObject(rawJson);
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
}
