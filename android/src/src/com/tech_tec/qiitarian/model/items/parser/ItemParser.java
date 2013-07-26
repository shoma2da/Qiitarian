package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.model.items.ArticleInfo;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.model.parser.UserParser;

public class ItemParser {
    
    public Item parse(JSONObject object) throws JSONException, MalformedURLException {
        ArticleInfo articleInfo = new ArticleInfoParser().parse(object);
        User user = new UserParser().parse(object.getJSONObject("user"));
        Uuid uuid = new UuidParser().parse(object);
        
        return new Item(articleInfo, user, uuid);
    }
    
}
