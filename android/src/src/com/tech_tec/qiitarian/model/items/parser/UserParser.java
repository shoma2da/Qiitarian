package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.User;

public class UserParser {
    
    public User parse(JSONObject object) throws JSONException, MalformedURLException {
        String urlName = object.getString("url_name");
        String profileImgUrlStr = object.getString("profile_image_url");
        URL profileImgUrl = new URL(profileImgUrlStr);
        
        return new User(urlName, profileImgUrl);
    }
    
}
