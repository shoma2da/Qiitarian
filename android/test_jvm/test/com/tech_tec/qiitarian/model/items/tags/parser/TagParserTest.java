package com.tech_tec.qiitarian.model.items.tags.parser;

import static junit.framework.Assert.*;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.tags.Tag;

public class TagParserTest {
    
    @Test
    public void 正常にパース出来ているか() throws MalformedURLException, JSONException {
        TagParser tagParser = new TagParser();
        
        Tag tag = tagParser.parse(new JSONObject("{ 'url_name':'java', 'icon_url':'http://tech-tec.com' }"));
        
        assertNotNull(tag);
    }
    
}
