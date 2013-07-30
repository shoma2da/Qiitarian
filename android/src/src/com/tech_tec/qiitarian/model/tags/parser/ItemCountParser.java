package com.tech_tec.qiitarian.model.tags.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.ItemCount;

public class ItemCountParser {
    
    public ItemCount parse(JSONObject object) throws JSONException {
        int count = object.getInt("item_count");
        return new ItemCount(count);
    }
}
