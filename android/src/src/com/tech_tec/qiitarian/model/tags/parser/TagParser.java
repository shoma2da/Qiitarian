package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.Name;
import com.tech_tec.qiitarian.model.tags.Tag;

public class TagParser {
    
    public Tag parse(JSONObject object) throws JSONException {
        Name name = new NameParser().parse(object);
        
        return new Tag(name);
    }
    
}
