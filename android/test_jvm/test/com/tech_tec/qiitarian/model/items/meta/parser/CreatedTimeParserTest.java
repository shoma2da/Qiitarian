package com.tech_tec.qiitarian.model.items.meta.parser;

import static junit.framework.Assert.*;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.meta.CreatedTime;

public class CreatedTimeParserTest {
    
    @Test
    public void CreatedTimeをパースして生成() throws JSONException, ParseException {
        CreatedTimeParser parser = new CreatedTimeParser();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ 'created_at'         :'2012-10-03 22:12:36 +0900',");
        stringBuilder.append("  'created_at_in_words': '18 hours ago' }");
        CreatedTime time = parser.parse(new JSONObject(stringBuilder.toString()));
        
        assertNotNull(time);
    }
    
}
