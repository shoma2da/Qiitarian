package com.tech_tec.qiitarian.model.tags.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.tags.IconImage;
import com.tech_tec.qiitarian.model.tags.ItemCount;
import com.tech_tec.qiitarian.model.tags.Name;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class TagParser {
    
    public Tag parse(JSONObject object) throws JSONException, MalformedURLException {
        Name name = new NameParser().parse(object);
        UrlName urlName = new UrlNameParser().parse(object);
        IconImage iconImage = new IconImageParser().parse(object);
        ItemCount itemCount = new ItemCountParser().parse(object);
        
        return new Tag(name, urlName, iconImage, itemCount);
    }
    
}
