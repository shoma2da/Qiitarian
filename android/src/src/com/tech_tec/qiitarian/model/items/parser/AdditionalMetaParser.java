package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.meta.AdditionalMeta;
import com.tech_tec.qiitarian.model.items.meta.Counts;
import com.tech_tec.qiitarian.model.items.tags.Tags;
import com.tech_tec.qiitarian.model.items.tags.parser.TagsParser;

public class AdditionalMetaParser {
    
    public AdditionalMeta parse(JSONObject object) throws MalformedURLException, JSONException {
        Tags tags = new TagsParser().parse(object.getJSONArray("tags"));
        Counts counts = new CountsParser().parse(object);
        
        return new AdditionalMeta(tags, counts);
    }
    
}
