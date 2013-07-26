package com.tech_tec.qiitarian.model.detail.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.detail.CommentBody;

public class CommentBodyParser {
    
    public CommentBody parse(JSONObject object) throws JSONException {
        String body = object.getString("body");
        return new CommentBody(body);
    }
    
}
