package com.tech_tec.qiitarian.model.user.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.Description;
import com.tech_tec.qiitarian.model.user.ProfileImage;
import com.tech_tec.qiitarian.model.user.UrlName;
import com.tech_tec.qiitarian.model.user.User;

public class UserParser {
    
    public User parse(JSONObject object) throws JSONException, MalformedURLException {
        UrlName urlName = new UrlNameParser().parse(object);
        ProfileImage profileImage = new ProfileImageParser().parse(object);
        Description description = new DescriptionParser().parse(object);
        
        return new User(urlName, profileImage, description);
    }
    
}
