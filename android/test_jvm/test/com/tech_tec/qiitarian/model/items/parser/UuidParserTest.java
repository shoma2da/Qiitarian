package com.tech_tec.qiitarian.model.items.parser;

import static junit.framework.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.Uuid;

public class UuidParserTest {
    
    @Test
    public void Uuidをパースする() throws JSONException {
        UuidParser parser = new UuidParser();
        Uuid uuid = parser.parse(new JSONObject("{ 'uuid':'abcde12345' }"));
        
        assertEquals(uuid, new Uuid("abcde12345"));
    }
    
}
