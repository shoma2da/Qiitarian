package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.ArticleInfo;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.User;

public class ItemParser {
    
    public Item parse(JSONObject object) throws JSONException, MalformedURLException {
        ArticleInfo articleInfo = new ArticleInfoParser().parse(object);
        User user = new UserParser().parse(object.getJSONObject("user"));
        
        return new Item(articleInfo, user);
    }
    
}
