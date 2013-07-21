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
        ArticleInfo articleInfo = parseArticleInfo(object);
        UserName userName = parseUserName(object);
        
        return new Item(userName, articleInfo);
    }
    
    private ArticleInfo parseArticleInfo(JSONObject object) throws JSONException {
        String titleText = object.getString("title");
        ArticleTitle title = new ArticleTitle(titleText);
        String createdAtText = object.getString("created_at_in_words");
        CreatedAt createdAt = new CreatedAt(createdAtText);
        
        return new ArticleInfo(title, createdAt);
    }
    
    private UserName parseUserName(JSONObject object) throws JSONException {
        JSONObject userObject = object.getJSONObject("user");
        return new UserNameParser().parser(userObject);
    }
    
}
