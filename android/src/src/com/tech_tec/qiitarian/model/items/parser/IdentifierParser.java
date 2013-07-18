package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Identifier;
import com.tech_tec.qiitarian.model.items.Uuid;

public class IdentifierParser {
    
    public Identifier parse(JSONObject object) throws MalformedURLException, JSONException {
        URL url = new URL(object.getString("url"));
        Uuid uuid = new UuidParser().parse(object);
        
        return new Identifier(uuid, url);
    }
    
}
