package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.Description;

public class DescriptionParser {
    
    public Description parse(JSONObject object) throws JSONException {
        if (object.get("description") == JSONObject.NULL) {
            return new Description(null);
        }

        String description = object.getString("description");
        return new Description(description);
    }
    
}
