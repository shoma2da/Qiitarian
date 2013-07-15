package com.tech_tec.qiitarian.model.items.parser;

import static junit.framework.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.Uuid;


public class ItemParserTest {
    
    private ItemParser mParser;
    
    @Before
    public void setUp() {
        mParser = new ItemParser();
    }
    
    @Test
    public void Uuidをパース() throws JSONException {
        JSONObject object = new JSONObject("{ 'uuid': 'abcde12345' }");
        Uuid uuid = mParser.parseUuid(object);
        
        assertTrue(uuid.equals(new Uuid("abcde12345")));
    }
    
}
