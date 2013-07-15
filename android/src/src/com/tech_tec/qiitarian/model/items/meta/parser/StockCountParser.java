package com.tech_tec.qiitarian.model.items.meta.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.StockCount;

public class StockCountParser {
    
    public StockCount parse(JSONObject object) throws JSONException {
        int count = object.getInt("stock_count");
        return new StockCount(count);
    }
    
}
