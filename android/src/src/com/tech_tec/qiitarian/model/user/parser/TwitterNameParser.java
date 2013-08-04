package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.TwitterName;

public class TwitterNameParser {
    
    public TwitterName parse(JSONObject object) throws JSONException {
        if (object.getString("twitter") == JSONObject.NULL) {
            return new TwitterName(null);
        }

        String name = object.getString("twitter");
        return new TwitterName(name);
    }
    
}
