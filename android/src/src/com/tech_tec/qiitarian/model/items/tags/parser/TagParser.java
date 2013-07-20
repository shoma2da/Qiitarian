package com.tech_tec.qiitarian.model.items.tags.parser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.tags.Tag;

public class TagParser {
    
    public Tag parse(JSONObject jsonObject) throws MalformedURLException, JSONException {
        String urlName = jsonObject.getString("url_name");
        
        return new Tag(urlName);
    }
    
}
