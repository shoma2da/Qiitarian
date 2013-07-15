package com.tech_tec.qiitarian.model.items.meta.parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.CreatedTime;

public class CreatedTimeParser {
    
    static DateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.JAPAN);
    
    public CreatedTime parse(JSONObject object) throws JSONException, ParseException {
        Date createdAt = convertToDate(object.getString("created_at"));
        String createdAtInWords = object.getString("created_at_in_words");
        
        return new CreatedTime(createdAt, createdAtInWords);
    }
    
    Date convertToDate(String dateStr) throws ParseException {
        return sDateFormat.parse(dateStr);
    }
    
}
