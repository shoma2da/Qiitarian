package com.tech_tec.qiitarian.model.detail.parser;

import java.io.PrintWriter;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.model.items.parser.UuidParser;
import com.tech_tec.qiitarian.model.parser.UserParser;

public class DetailParser {
    
    public Detail parse(JSONObject object) throws MalformedURLException, JSONException {
        Uuid uuid = new UuidParser().parse(object);
        User user = new UserParser().parse(object.getJSONObject("user"));
        
        return new Detail(uuid, user);
    }
    
}
