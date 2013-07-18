package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.CommentCount;
import com.tech_tec.qiitarian.model.items.meta.Counts;
import com.tech_tec.qiitarian.model.items.meta.StockCount;
import com.tech_tec.qiitarian.model.items.meta.parser.CommentCountParser;
import com.tech_tec.qiitarian.model.items.meta.parser.StockCountParser;

public class CountsParser {
    
    public Counts parse(JSONObject object) throws JSONException {
        StockCount stockCount = new StockCountParser().parse(object);
        CommentCount commentCount = new CommentCountParser().parse(object);
        
        return new Counts(stockCount, commentCount);
    }
    
}
