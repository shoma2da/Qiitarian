package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.ArticleTitle;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.UserName;

public class ItemParser {
    
    public Item parser(JSONObject object) throws JSONException {
        String titleText = object.getString("title");
        ArticleTitle title = new ArticleTitle(titleText);
        
        JSONObject userObject = object.getJSONObject("user");
        UserName userName = new UserNameParser().parser(userObject);
        
        String createdAtText = object.getString("created_at_in_words");
        CreatedAt createdAt = new CreatedAt(createdAtText);
        
        return new Item(title, userName, createdAt);
    }
    
}
