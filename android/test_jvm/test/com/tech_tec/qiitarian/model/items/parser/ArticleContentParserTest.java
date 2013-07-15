package com.tech_tec.qiitarian.model.items.parser;

import static junit.framework.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.ArticleContent;

public class ArticleContentParserTest {
    
    @Test
    public void ArticleContentをパースする() throws JSONException {
        JSONObject object = new JSONObject("{ 'title':'テストタイトル', 'body':'テストボディ<br>' }");
        
        ArticleContent content = new ArticleContentParser().parse(object);
        assertNotNull(content);
    }
    
}
