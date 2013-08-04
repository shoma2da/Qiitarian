package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.FacebookName;

public class FacebookNameParser {
    
    public FacebookName parse(JSONObject object) throws JSONException {
        String name = object.getString("facebook");
        return new FacebookName(name);
    }
    
}
