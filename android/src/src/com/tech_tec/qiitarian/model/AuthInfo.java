package com.tech_tec.qiitarian.model;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.http.AndroidHttpClient;

public class AuthInfo {
    private static final String PREF_NAME = "authinfo.xml";
    private static final String KEY_SERVICE = "service";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_TOKEN = "token";
    
    private SharedPreferences mPreferences;
    private String mUserAgent;
    
    private static AuthInfo INSTANCE;
    private AuthInfo(Context context, String useragent) {
        mPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mUserAgent = useragent;
    }
    public static AuthInfo getInstance(Context context, String userAgent) {
        if (INSTANCE == null) {
            INSTANCE = new AuthInfo(context, userAgent);
        }
        return INSTANCE;
    }
    
    public LoginService getService() {
        String serviceStr = mPreferences.getString(KEY_SERVICE, null);
        return LoginService.getByName(serviceStr);
    }

    public void setService(LoginService service) {
        mPreferences.edit().putString(KEY_USERNAME, service.toString()).commit();
    }

    public String getUsername() {
        return mPreferences.getString(KEY_USERNAME, null);
    }

    public void setUsername(String username) {
        mPreferences.edit().putString(KEY_USERNAME, username).commit();
    }

    public String getToken() {
        return mPreferences.getString(KEY_TOKEN, null);
    }

    public void setToken(String token) {
        mPreferences.edit().putString(KEY_TOKEN, token).commit();
    }
    
    public interface OnUpdateCallback {
        void onUpdate(ResponseType responseType);
    }
    
    public void updateAuthInfo(String username, String password, LoginService service, OnUpdateCallback callback) {
        String url = String.format("https://qiita.com/api/v1/auth?url_name=%s&password=%s", service.convert(username), password);
        
        AndroidHttpClient client = AndroidHttpClient.newInstance(mUserAgent);
        try {
            HttpResponse response = client.execute(new HttpPost(url));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            response.getEntity().writeTo(outputStream);
            String rawJson = outputStream.toString();
            outputStream.close();
            
            JSONObject json = new JSONObject(rawJson);
            
            if (json.has("token")) {
                String token = json.getString("token");
                
                setToken(token);
                setUsername(username);
                setService(service);
                
                callback.onUpdate(ResponseType.SUCCESS);
            } else {
                setToken(null);
                setUsername(username);
                setService(service);
                
                callback.onUpdate(ResponseType.FAILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            callback.onUpdate(ResponseType.ERROR);
        } finally {
            client.close();
        }
    }
}
