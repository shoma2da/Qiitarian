package com.tech_tec.qiitarian.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.http.AndroidHttpClient;

import com.tech_tec.qiitarian.model.AuthInfo;

public class ApiAccessor {
    
    @Inject Context mContext;
    @Inject String mUserAgent;
    
    public static final String API_BASE = "https://qiita.com/api/v1";
    
    public AuthInfo auth(String username, String password) throws ClientProtocolException, IOException, JSONException {
        String url = String.format("%s/auth?url_name=%s&password=%s", API_BASE, username, password);
        
        AndroidHttpClient client = AndroidHttpClient.newInstance(mUserAgent);
        String rawJson = client.execute(new HttpPost(url), new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                response.getEntity().writeTo(outputStream);
                String result = outputStream.toString();
                outputStream.close();
                return result;
            }
        });
        client.close();
        
        JSONObject json = new JSONObject(rawJson);
        String token = json.getString("token");
        
        AuthInfo authInfo = new AuthInfo();
        authInfo.setToken(token);
        authInfo.setUsername(username);
        return authInfo;
    }
}
