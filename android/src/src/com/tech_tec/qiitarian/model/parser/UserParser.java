package com.tech_tec.qiitarian.model.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.model.items.UrlName;
import com.tech_tec.qiitarian.model.items.UserProfileImg;
import com.tech_tec.qiitarian.model.items.parser.UrlNameParser;
import com.tech_tec.qiitarian.model.items.parser.UserProfileImgParser;

public class UserParser {
    
    public User parse(JSONObject object) throws JSONException, MalformedURLException {
        UrlName userName = new UrlNameParser().parser(object);
        UserProfileImg userProfileImg = new UserProfileImgParser().parse(object);
        
        return new User(userName, userProfileImg);
    }
    
}
