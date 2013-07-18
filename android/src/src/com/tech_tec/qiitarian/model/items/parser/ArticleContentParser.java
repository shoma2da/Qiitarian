package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.ArticleContent;
import com.tech_tec.qiitarian.model.items.ArticleTitle;

public class ArticleContentParser {
    
    public ArticleContent parse(JSONObject object) throws JSONException {
        String title = object.getString("title");
        String body = object.getString("body");
        
        return new ArticleContent(new ArticleTitle(title), body);
    }
    
}
