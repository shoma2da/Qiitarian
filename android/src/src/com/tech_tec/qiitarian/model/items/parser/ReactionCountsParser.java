package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.StockCount;
import com.tech_tec.qiitarian.model.items.CommentCount;
import com.tech_tec.qiitarian.model.items.ReactionCounts;
import com.tech_tec.qiitarian.model.parser.StockCountParser;

public class ReactionCountsParser {
    
    public ReactionCounts parseReactionCounts(JSONObject object) throws JSONException {
        StockCount stockCount = new StockCountParser().parse(object);
        CommentCount commentCount = new CommentCountParser().parse(object);
        
        return new ReactionCounts(commentCount, stockCount);
    }
    
}
