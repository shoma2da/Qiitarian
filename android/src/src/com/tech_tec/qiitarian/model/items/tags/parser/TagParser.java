package com.tech_tec.qiitarian.model.items.tags.parser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.tags.Tag;

public class TagParser {
    
    public Tag parse(JSONObject jsonObject) throws MalformedURLException, JSONException {
        String urlName = jsonObject.getString("url_name");
        String iconUrlStr = jsonObject.getString("icon_url");
        URL iconUrl = new URL(iconUrlStr);
        
        return new Tag(urlName, iconUrl);
    }
    
}
