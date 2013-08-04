package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.UrlName;

public class UrlNameParser {
    
    public UrlName parse(JSONObject object) throws JSONException {
        String name = object.getString("url_name");
        return new UrlName(name);
    }
    
}
