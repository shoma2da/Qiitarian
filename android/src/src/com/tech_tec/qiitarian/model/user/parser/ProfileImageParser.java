package com.tech_tec.qiitarian.model.user.parser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.ProfileImage;

public class ProfileImageParser {
    
    public ProfileImage parse(JSONObject object) throws JSONException, MalformedURLException {
        String urlStr = object.getString("profile_image_url");
        URL url = new URL(urlStr);
        
        return new ProfileImage(url);
    }
    
}
