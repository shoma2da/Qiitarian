package com.tech_tec.qiitarian.model.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.ArticleTitle;

public class ArticleTitleParser {
    
    public ArticleTitle parse(JSONObject object) throws JSONException {
        String titleText = object.getString("title");
        return new ArticleTitle(titleText);
    }
    
}
