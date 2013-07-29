package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.model.tags.Tags;

public class TagsParser {
    
    public Tags parse(JSONArray array) throws JSONException {
        QiitarianLog.d("start tags parse");
        
        Tags tags = new Tags();
        
        TagParser tagParser = new TagParser();
        int size = array.length();
        for (int i = 0; i < size; i++) {
            JSONObject object = array.getJSONObject(i);
            Tag tag = tagParser.parse(object);
            tags.add(tag);
        }
        
        QiitarianLog.d("end tags parse");
        return tags;
    }
    
}
