package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.Name;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class TagParser {
    
    public Tag parse(JSONObject object) throws JSONException {
        Name name = new NameParser().parse(object);
        UrlName urlName = new UrlNameParser().parse(object);
        
        return new Tag(name, urlName);
    }
    
}
