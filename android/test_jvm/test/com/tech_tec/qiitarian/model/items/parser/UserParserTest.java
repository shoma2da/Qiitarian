package com.tech_tec.qiitarian.model.items.parser;

import static junit.framework.Assert.*;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.tech_tec.qiitarian.model.items.meta.User;

public class UserParserTest {
    
    @Test
    public void ユーザをパースする() throws MalformedURLException, JSONException {
        UserParser parser = new UserParser();
        User user = parser.parse(new JSONObject("{ 'url_name':'shoma2da', 'profile_image_url':'http://tech-tec.com' }"));
        
        assertNotNull(user);
    }
    
}
