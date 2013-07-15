package com.tech_tec.qiitarian.model.items.meta.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.CommentCount;

public class CommentCountParser {
    
    public CommentCount parse(JSONObject object) throws JSONException {
        int count = object.getInt("comment_count");
        return new CommentCount(count);
    }
    
}
