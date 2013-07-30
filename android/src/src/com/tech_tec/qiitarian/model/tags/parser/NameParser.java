package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.Name;

public class NameParser {
    
    public Name parse(JSONObject object) throws JSONException {
        String nameStr = object.getString("name");
        return new Name(nameStr);
    }
    
}
