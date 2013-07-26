package com.tech_tec.qiitarian.model.items.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.CreatedAt;

public class CreatedAtParser {
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.JAPANESE);
    
    public CreatedAt parse(JSONObject object) throws JSONException, ParseException {
        String createdAtInWords = object.getString("created_at_in_words");
        String createdAtStr = object.getString("created_at");
        Date createdAt = DATE_FORMAT.parse(createdAtStr);
        
        return new CreatedAt(createdAtInWords, createdAt);
    }
    
}
