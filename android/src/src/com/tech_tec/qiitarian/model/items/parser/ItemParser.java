package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Uuid;

public class ItemParser {
    
    public Item parser(JSONObject object) {
        return new Item();
    }
    
    Uuid parseUuid(JSONObject object) throws JSONException {
        String uuidStr = object.getString("uuid");
        return new Uuid(uuidStr);
    }
}
