package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.common.StockCount;
import com.tech_tec.qiitarian.model.common.parser.StockCountParser;
import com.tech_tec.qiitarian.model.items.CommentCount;
import com.tech_tec.qiitarian.model.items.ReactionCounts;

public class ReactionCountsParser {
    
    public ReactionCounts parseReactionCounts(JSONObject object) throws JSONException {
        StockCount stockCount = new StockCountParser().parse(object);
        CommentCount commentCount = new CommentCountParser().parse(object);
        
        return new ReactionCounts(commentCount, stockCount);
    }
    
}
