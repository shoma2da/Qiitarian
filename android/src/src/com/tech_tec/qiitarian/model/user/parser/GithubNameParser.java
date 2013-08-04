package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.GithubName;

public class GithubNameParser {
    
    public GithubName parse(JSONObject object) throws JSONException {
        if (object.get("github") == JSONObject.NULL) {
            return new GithubName(null);
        }
        
        String name = object.getString("github");
        return new GithubName(name);
    }
    
}
