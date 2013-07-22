package com.tech_tec.qiitarian.activity.task;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.tech_tec.qiitarian.model.items.http.HttpResponseWrapper;
import com.tech_tec.qiitarian.old.model.AuthInfo;
import com.tech_tec.qiitarian.old.model.LoginService;
import com.tech_tec.qiitarian.old.model.http.AuthInfoClient;
import com.tech_tec.qiitarian.old.model.parser.AuthInfoParser;

public class AuthInfoFetcher {
    
    public AuthInfo fetch(String username, String password, LoginService service) throws ClientProtocolException, IOException, ParseException, JSONException {
        AuthInfoClient client = createAuthInfoClient();
        HttpResponseWrapper response = client.execute(username, password, service);
        
        return processResponse(response);
    }
    
    AuthInfoClient createAuthInfoClient() {
        return new AuthInfoClient();
    }
    
    private AuthInfo processResponse(HttpResponseWrapper response) throws ParseException, JSONException, IOException {
        if (response.isOK()) {
            return createAuthInfoParser().parse(response.toJSONObject());
        } else {
            return AuthInfo.NULL;
        }
    }
    
    AuthInfoParser createAuthInfoParser() {
        return new AuthInfoParser();
    }
}
