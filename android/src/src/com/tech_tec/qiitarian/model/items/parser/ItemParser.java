package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.ArticleInfo;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.UserName;

public class ItemParser {
    
    public Item parse(JSONObject object) throws JSONException {
        ArticleInfo articleInfo = new ArticleInfoParser().parse(object);
        UserName userName = new UserNameParser().parser(object.getJSONObject("user"));
        
        return new Item(userName, articleInfo);
    }
    
}
