package com.tech_tec.qiitarian.model.common.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.common.User;
import com.tech_tec.qiitarian.model.common.UserProfileImg;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.items.parser.UserUrlNameParser;
import com.tech_tec.qiitarian.model.items.parser.UserProfileImgParser;

public class UserParser {
    
    public User parse(JSONObject object) throws JSONException, MalformedURLException {
        UserUrlName userName = new UserUrlNameParser().parser(object);
        UserProfileImg userProfileImg = new UserProfileImgParser().parse(object);
        
        return new User(userName, userProfileImg);
    }
    
}
