package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.CommentCount;

public class CommentCountParser {
    
    public CommentCount parse(JSONObject object) throws JSONException {
        int commentCount = object.getInt("comment_count");
        return new CommentCount(commentCount);
    }
    
}
