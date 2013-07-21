package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Tag;

public class TagParser {
    
    public Tag parse(JSONObject object) throws JSONException {
        String tagText = object.getString("name");
        return new Tag(tagText);
    }
    
}
