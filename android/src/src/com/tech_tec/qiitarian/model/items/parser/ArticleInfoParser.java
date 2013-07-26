package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.ArticleTitle;
import com.tech_tec.qiitarian.model.items.ArticleInfo;
import com.tech_tec.qiitarian.model.items.ArticleMeta;
import com.tech_tec.qiitarian.model.parser.ArticleTitleParser;

public class ArticleInfoParser {
    
    public ArticleInfo parse(JSONObject object) throws JSONException {
        ArticleTitle title = new ArticleTitleParser().parse(object);
        ArticleMeta articleMeta = new ArticleMetaParser().parse(object);
        
        return new ArticleInfo(title, articleMeta);
    }
    
    
}
