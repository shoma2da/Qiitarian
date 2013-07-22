package com.tech_tec.qiitarian.model.auth.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.Token;
import com.tech_tec.qiitarian.model.auth.UrlName;

public class AuthInfoParser {
    
    public AuthInfo parse(JSONObject object) throws JSONException {
        String urlName = object.getString("url_name");
        String token = object.getString("token");
        
        return new AuthInfo(new UrlName(urlName), new Token(token));
    }
    
}
