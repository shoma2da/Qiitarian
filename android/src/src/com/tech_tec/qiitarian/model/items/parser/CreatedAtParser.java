package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.CreatedAt;

public class CreatedAtParser {
    
    public CreatedAt parse(JSONObject object) throws JSONException {
        String createdAtText = object.getString("created_at_in_words");
        return new CreatedAt(createdAtText);
    }
    
}
