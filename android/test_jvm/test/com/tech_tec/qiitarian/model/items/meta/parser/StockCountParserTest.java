package com.tech_tec.qiitarian.model.items.meta.parser;

import static junit.framework.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.meta.StockCount;

public class StockCountParserTest {
    
    @Test
    public void 正常にストック数をパース() throws JSONException {
        StockCountParser parser = new StockCountParser();
        StockCount count = parser.parse(new JSONObject("{ 'stock_count': 10}"));
        
        assertNotNull(count);
    }
    
}
