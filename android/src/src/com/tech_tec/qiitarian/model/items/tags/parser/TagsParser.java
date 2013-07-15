package com.tech_tec.qiitarian.model.items.tags.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.tags.Tag;
import com.tech_tec.qiitarian.model.items.tags.Tags;

//TODO ItemsParserと重複しまくり！
public class TagsParser {
    
    private TagParser mTagParser;
    
    public TagsParser() {
        mTagParser = createTagParser();
    }
    
    TagParser createTagParser() {
        return new TagParser();
    }
    
    public Tags parse(JSONArray jsonArray) throws JSONException {
        Tags tags = new Tags();
        
        int arrayLength = jsonArray.length();
        for (int i = 0; i < arrayLength; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Tag tag = mTagParser.parse(jsonObject);
            tags.add(tag);
        }
        
        return tags;
    }
    
}
