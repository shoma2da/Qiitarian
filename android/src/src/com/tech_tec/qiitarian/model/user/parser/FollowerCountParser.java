package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.FollowerCount;

public class FollowerCountParser {
    
    public FollowerCount parse(JSONObject object) throws JSONException {
        int count = object.getInt("followers");
        return new FollowerCount(count);
    }
    
}
