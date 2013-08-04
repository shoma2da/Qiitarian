package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.FollowingCount;

public class FollowingCountParser {
    
    public FollowingCount parse(JSONObject object) throws JSONException {
        int count = object.getInt("following_users");
        return new FollowingCount(count);
    }
    
}
