package com.tech_tec.qiitarian.model.common.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.common.ArticleTitle;

public class ArticleTitleParser {
    
    public ArticleTitle parse(JSONObject object) throws JSONException {
        String titleText = object.getString("title");
        return new ArticleTitle(titleText);
    }
    
}
