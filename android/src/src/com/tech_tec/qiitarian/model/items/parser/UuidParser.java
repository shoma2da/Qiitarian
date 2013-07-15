package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Uuid;

public class UuidParser {
    
    public Uuid parse(JSONObject object) throws JSONException {
        String uuidStr = object.getString("uuid");
        return new Uuid(uuidStr);
    }
    
}
