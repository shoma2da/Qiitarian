package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.ArticleInfo;
import com.tech_tec.qiitarian.model.items.ArticleTitle;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.UserName;

public class ItemParser {
    
    public Item parse(JSONObject object) throws JSONException {
        String titleText = object.getString("title");
        ArticleTitle title = new ArticleTitle(titleText);
        String createdAtText = object.getString("created_at_in_words");
        CreatedAt createdAt = new CreatedAt(createdAtText);
        ArticleInfo articleInfo = new ArticleInfo(title, createdAt);
        
        JSONObject userObject = object.getJSONObject("user");
        UserName userName = new UserNameParser().parser(userObject);
        
        return new Item(userName, articleInfo);
    }
    
}
