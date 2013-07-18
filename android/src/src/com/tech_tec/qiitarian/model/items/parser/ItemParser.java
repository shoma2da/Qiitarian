package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Article;
import com.tech_tec.qiitarian.model.items.Identifier;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.model.items.meta.User;

public class ItemParser {
    
    public Item parser(JSONObject object) throws JSONException, MalformedURLException, ParseException {
        Identifier identifier = new IdentifierParser().parse(object);
        Article article = new ArticleParser().parse(object);
        
        return new Item(identifier, article);
    }
    
}
