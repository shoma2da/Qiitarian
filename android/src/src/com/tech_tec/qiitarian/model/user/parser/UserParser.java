package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.UrlName;
import com.tech_tec.qiitarian.model.user.User;

public class UserParser {
    
    public User parse(JSONObject object) throws JSONException {
        UrlName urlName = new UrlNameParser().parse(object);
        
        return new User(urlName);
    }
    
}
