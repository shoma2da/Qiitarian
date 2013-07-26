package com.tech_tec.qiitarian.model.detail.parser;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.ArticleTitle;
import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.model.items.StockCount;
import com.tech_tec.qiitarian.model.items.parser.CreatedAtParser;
import com.tech_tec.qiitarian.model.items.parser.StockCountParser;
import com.tech_tec.qiitarian.model.parser.ArticleTitleParser;
import com.tech_tec.qiitarian.model.parser.UserParser;

public class DetailParser {
    
    public Detail parse(JSONObject object) throws MalformedURLException, JSONException, ParseException {
        User user = new UserParser().parse(object.getJSONObject("user"));
        ArticleTitle articleTitle = new ArticleTitleParser().parse(object);
        CreatedAt createdAt = new CreatedAtParser().parse(object);
        StockCount stockCount = new StockCountParser().parse(object);
        
        return new Detail(user, articleTitle, createdAt, stockCount);
    }
    
}
