package com.tech_tec.qiitarian.old.model.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.old.model.AuthInfo;
import com.tech_tec.qiitarian.old.model.Token;
import com.tech_tec.qiitarian.old.model.UrlName;

public class AuthInfoParser {
    
    public AuthInfo parse(JSONObject object) throws JSONException {
        String urlName = object.getString("url_name");
        String token = object.getString("token");
        
        return new AuthInfo(new UrlName(urlName), new Token(token));
    }
    
}
