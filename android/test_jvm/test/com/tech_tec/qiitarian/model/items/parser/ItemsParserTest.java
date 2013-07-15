package com.tech_tec.qiitarian.model.items.parser;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public class ItemsParserTest {
    
    private ItemsParser mParser;
    
    @Before
    public void setUp() {
        mParser = new ItemsParser() {
            @Override
            ItemParser createItemParser() {
                ItemParser mockParser = mock(ItemParser.class);
                when(mockParser.parser((JSONObject)any())).thenReturn(mock(Item.class));
                return mockParser;
            }
        };
    }
    
    @Test
    public void 空のitemsオブジェクトを生成() throws JSONException {
        Items items = mParser.parse(new JSONArray("[]"));
        
        assertNotNull(items);
        assertTrue(items.isEmpty());
        assertEquals(0, items.size());
    }
    
    @Test
    public void 要素のあるItemsを生成() throws JSONException {
        Items items = mParser.parse(new JSONArray("[{}, {}, {}]")); //３要素
        
        assertFalse(items.isEmpty());
        assertEquals(3, items.size());
    }
    
    @Test
    public void InputStreamから空のItemsを生成() throws JSONException {
        InputStream input = new ByteArrayInputStream("[]".getBytes());
        Items items = mParser.parse(input);
        
        assertNotNull(items);
        assertTrue(items.isEmpty());
        assertEquals(0, items.size());
    }
}
