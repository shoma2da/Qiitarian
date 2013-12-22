package com.tech_tec.qiitarian.model.detail.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.detail.IsStocked;

public class IsStockedParser {
    
    public IsStocked parse(JSONObject object) throws JSONException {
        String isStockedStr = object.getString("stocked");
        if (isStockedStr.equals("null") || isStockedStr.equals("false")) {
            return new IsStocked(false);
        }
        
        return new IsStocked(true);
    }
    
}
