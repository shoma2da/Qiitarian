package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.CreatedTime;
import com.tech_tec.qiitarian.model.items.meta.DefaultMeta;
import com.tech_tec.qiitarian.model.items.meta.User;
import com.tech_tec.qiitarian.model.items.meta.parser.CreatedTimeParser;

public class DefaultMetaParser {
    
    public DefaultMeta parse(JSONObject object) throws MalformedURLException, JSONException, ParseException {
        User user = new UserParser().parse(object.getJSONObject("user"));
        CreatedTime time = new CreatedTimeParser().parse(object);
        
        return new DefaultMeta(user, time);
    }
    
}
