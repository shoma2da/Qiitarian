package com.tech_tec.qiitarian.model.tags.parser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.IconImage;

public class IconImageParser {
    
    public IconImage parse(JSONObject object) throws JSONException, MalformedURLException {
        String urlStr = object.getString("icon_url");
        URL url = new URL(urlStr);
        return new IconImage(url);
    }
    
}
