package com.tech_tec.qiitarian.model.item;

import org.json.JSONException;
import org.json.JSONObject;

import junit.framework.TestCase;

public class ItemsParserTest extends TestCase {
    
    public void test空のitemsオブジェクトを生成() throws JSONException {
        ItemsParser parser = new ItemsParser();
        Items items = parser.parse(new JSONObject("{}"));
        
        assertNotNull(items);
        //assertFalse(items.isEmpty());
    }
    
}
