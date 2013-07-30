package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.FollowerCount;

public class FollowerCountParser {
    
    public FollowerCount parse(JSONObject object) throws JSONException {
        int count = object.getInt("follower_count");
        return new FollowerCount(count);
    }
    
}
