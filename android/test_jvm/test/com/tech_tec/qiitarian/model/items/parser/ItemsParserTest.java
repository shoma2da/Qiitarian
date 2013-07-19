package com.tech_tec.qiitarian.model.items.parser;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.ParseException;

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
                try {
                    when(mockParser.parser((JSONObject)any())).thenReturn(mock(Item.class));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return mockParser;
            }
        };
    }
    
    @Test
    public void 空のitemsオブジェクトを生成() throws JSONException, MalformedURLException, ParseException {
        Items items = mParser.parse(new JSONArray("[]"));
        
        assertNotNull(items);
        assertTrue(items.isEmpty());
        assertEquals(0, items.size());
    }
    
    @Test
    public void 要素のあるItemsを生成() throws JSONException, MalformedURLException, ParseException {
        Items items = mParser.parse(new JSONArray("[{}, {}, {}]")); //３要素
        
        assertFalse(items.isEmpty());
        assertEquals(3, items.size());
    }
    
}
