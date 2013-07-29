package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONArray;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.tags.Tags;

public class TagsParser {
    
    public Tags parse(JSONArray array) {
        QiitarianLog.d("start tags parse");
        
        Tags tags = new Tags();
        
        QiitarianLog.d("end tags parse");
        return tags;
    }
    
}
