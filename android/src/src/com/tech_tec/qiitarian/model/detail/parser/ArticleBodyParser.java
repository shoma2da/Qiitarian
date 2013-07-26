package com.tech_tec.qiitarian.model.detail.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.detail.ArticleBody;

public class ArticleBodyParser {
    
    public ArticleBody parse(JSONObject object) throws JSONException {
        String body = object.getString("body");
        return new ArticleBody(body);
    }
    
}
