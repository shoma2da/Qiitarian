package com.tech_tec.qiitarian.model.user.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.ItemCount;

public class ItemCountParser {
    
    public ItemCount parse(JSONObject object) throws JSONException {
        int count = object.getInt("items");
        return new ItemCount(count);
    }
    
}
