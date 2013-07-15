package com.tech_tec.qiitarian.model.items.tags.parser;

import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.tags.Tag;

public class TagParser {
    
    public Tag parse(JSONObject object) {
        return new Tag();
    }
    
}
