package com.tech_tec.qiitarian.model.items.meta.parser;

import static junit.framework.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.meta.CommentCount;

public class CommentCountParserTest {
    
    @Test
    public void 正常にコメント数をパース() throws JSONException {
        CommentCountParser parser = new CommentCountParser();
        CommentCount count = parser.parse(new JSONObject("{ 'comment_count':10 }"));
        
        assertNotNull(count);
    }
    
}
