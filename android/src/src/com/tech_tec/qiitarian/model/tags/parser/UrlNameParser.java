package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.UrlName;

public class UrlNameParser {
    
    public UrlName parse(JSONObject object) throws JSONException {
        String urlNameStr = object.getString("url_name");
        return new UrlName(urlNameStr);
    }
    
}
