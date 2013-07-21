package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.ArticleInfo;
import com.tech_tec.qiitarian.model.items.ArticleMeta;
import com.tech_tec.qiitarian.model.items.ArticleTitle;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.StockCount;
import com.tech_tec.qiitarian.model.items.Tags;
import com.tech_tec.qiitarian.model.items.UserName;

public class ItemParser {
    
    public Item parse(JSONObject object) throws JSONException {
        ArticleInfo articleInfo = parseArticleInfo(object);
        UserName userName = parseUserName(object);
        StockCount stockCount = parseStockCount(object);
        
        return new Item(userName, articleInfo, stockCount);
    }
    
    private ArticleInfo parseArticleInfo(JSONObject object) throws JSONException {
        String titleText = object.getString("title");
        ArticleTitle title = new ArticleTitle(titleText);
        ArticleMeta articleMeta = parseArticleMeta(object);
        
        return new ArticleInfo(title, articleMeta);
    }
    
    private ArticleMeta parseArticleMeta(JSONObject object) throws JSONException {
        String createdAtText = object.getString("created_at_in_words");
        CreatedAt createdAt = new CreatedAt(createdAtText);
        Tags tags = parseTags(object);
        
        return new ArticleMeta(createdAt, tags);
    }
    
    private UserName parseUserName(JSONObject object) throws JSONException {
        JSONObject userObject = object.getJSONObject("user");
        return new UserNameParser().parser(userObject);
    }
    
    private Tags parseTags(JSONObject object) throws JSONException {
        JSONArray tagsArray = object.getJSONArray("tags");
        return new TagsParser().parse(tagsArray);
    }
    
    private StockCount parseStockCount(JSONObject object) throws JSONException {
        int stockCount = object.getInt("stock_count");
        return new StockCount(stockCount);
    }
    
}
