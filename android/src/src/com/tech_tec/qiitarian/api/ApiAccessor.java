package com.tech_tec.qiitarian.api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.LoginService;

public class ApiAccessor {
    
    public static final String API_BASE = "https://qiita.com/api/v1";
    
    private JSONObjectFactory mJsonObjectFactory;
    
    public ApiAccessor(JSONObjectFactory jsonObjectFactory) {
        mJsonObjectFactory = jsonObjectFactory;
    }
    
    public AuthInfo auth(String username, String password, LoginService service) throws ClientProtocolException, IOException, JSONException {
        String url = String.format("%s/auth?url_name=%s&password=%s", API_BASE, service.convert(username), password);
        return createAuthInfo(mJsonObjectFactory.create(url), username, service);
    }
    
    private AuthInfo createAuthInfo(JSONObject json, String username, LoginService service) throws JSONException {
        if (json.has("token")) {
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
    
    public interface JSONObjectFactory {
        JSONObject create(String url) throws IOException, JSONException;
    }
}
