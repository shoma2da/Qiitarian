package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Article;
import com.tech_tec.qiitarian.model.items.ArticleContent;
import com.tech_tec.qiitarian.model.items.meta.ArticleMeta;
import com.tech_tec.qiitarian.model.items.meta.parser.ArticleMetaParser;

public class ArticleParser {
    
    public Article parse(JSONObject object) throws JSONException, MalformedURLException, ParseException {
        ArticleMeta meta = new ArticleMetaParser().parse(object);
        ArticleContent content = new ArticleContentParser().parse(object);
        
        return new Article(meta, content);
    }
    
}
