package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.common.UserProfileImg;

public class UserProfileImgParser {
    
    public UserProfileImg parse(JSONObject object) throws MalformedURLException, JSONException {
        URL url = new URL(object.getString("profile_image_url"));
        return new UserProfileImg(url);
    }
    
}
