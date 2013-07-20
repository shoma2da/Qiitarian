package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.UserName;

public class UserNameParser {
    
    public UserName parser(JSONObject object) throws JSONException {
        String userName = object.getString("url_name");
        return new UserName(userName);
    }
    
}
