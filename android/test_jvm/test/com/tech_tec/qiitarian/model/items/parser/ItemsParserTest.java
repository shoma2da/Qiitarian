package com.tech_tec.qiitarian.model.items.parser;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.Items;

public class ItemsParserTest {
    
    @Test
    public void 空のitemsオブジェクトを生成() throws JSONException {
        ItemsParser parser = new ItemsParser();
        Items items = parser.parse(new JSONArray("[]"));
        
        assertNotNull(items);
        assertTrue(items.isEmpty());
        assertEquals(0, items.size());
    }
    
    @Test
    public void 要素のあるItemsを生成() throws JSONException {
        ItemsParser parser = new ItemsParser();
        Items items = parser.parse(new JSONArray("[{}, {}, {}]")); //３要素
        
        assertFalse(items.isEmpty());
        assertEquals(3, items.size());
    }
    
    @Test
    public void InputStreamから空のItemsを生成() throws JSONException {
        InputStream input = new ByteArrayInputStream("[]".getBytes());
        
        ItemsParser parser = new ItemsParser();
        Items items = parser.parse(input);
        
        assertNotNull(items);
        assertTrue(items.isEmpty());
        assertEquals(0, items.size());
    }
}
