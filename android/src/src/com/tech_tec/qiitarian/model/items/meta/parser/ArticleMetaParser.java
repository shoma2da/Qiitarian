package com.tech_tec.qiitarian.model.items.meta.parser;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.AdditionalMeta;
import com.tech_tec.qiitarian.model.items.meta.ArticleMeta;
import com.tech_tec.qiitarian.model.items.meta.DefaultMeta;
import com.tech_tec.qiitarian.model.items.parser.AdditionalMetaParser;
import com.tech_tec.qiitarian.model.items.parser.DefaultMetaParser;

public class ArticleMetaParser {
    
    public ArticleMeta parse(JSONObject object) throws MalformedURLException, JSONException, ParseException {
        DefaultMeta defaultMeta = new DefaultMetaParser().parse(object);
        AdditionalMeta additionalMeta = new AdditionalMetaParser().parse(object);
        
        return new ArticleMeta(defaultMeta, additionalMeta);
    }
    
}
