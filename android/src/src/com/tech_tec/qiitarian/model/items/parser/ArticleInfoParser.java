package com.tech_tec.qiitarian.model.items.parser;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.common.ArticleTitle;
import com.tech_tec.qiitarian.model.common.parser.ArticleTitleParser;
import com.tech_tec.qiitarian.model.items.ArticleInfo;
import com.tech_tec.qiitarian.model.items.ArticleMeta;

public class ArticleInfoParser {
    
    public ArticleInfo parse(JSONObject object) throws JSONException, ParseException {
        ArticleTitle title = new ArticleTitleParser().parse(object);
        ArticleMeta articleMeta = new ArticleMetaParser().parse(object);
        
        return new ArticleInfo(title, articleMeta);
    }
    
    
}
