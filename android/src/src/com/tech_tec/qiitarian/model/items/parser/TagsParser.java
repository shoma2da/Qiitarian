package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Tag;
import com.tech_tec.qiitarian.model.items.Tags;

public class TagsParser {
    
    public Tags parse(JSONArray array) throws JSONException {
        Tags tags = new Tags();
        
        int length = array.length();
        for (int i = 0; i < length; i++) {
            addTagTo(tags, array.getJSONObject(i));
        }
        
        return tags;
    }
    
    void addTagTo(Tags tags, JSONObject jsonObject) {
        try {
            Tag tag = createTag(jsonObject);
            tags.add(tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
    Tag createTag(JSONObject object) throws JSONException {
        String tagText = object.getString("name");
        return new Tag(tagText);
    }
    
}
