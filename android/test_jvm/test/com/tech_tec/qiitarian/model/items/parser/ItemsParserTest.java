package com.tech_tec.qiitarian.model.items.parser;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.Items;

public class ItemsParserTest {
    
    @Test
    public void 空のitemsオブジェクトを生成() throws JSONException {
        ItemsParser parser = new ItemsParser();
        Items items = parser.parse(new JSONObject("{}"));
        
        assertNotNull(items);
        assertTrue(items.isEmpty());
        assertEquals(0, items.size());
    }
    
}
