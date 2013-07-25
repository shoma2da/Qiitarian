package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.UrlName;

public class UrlNameParser {
    
    public UrlName parser(JSONObject object) throws JSONException {
        String userName = object.getString("url_name");
        return new UrlName(userName);
    }
    
}
