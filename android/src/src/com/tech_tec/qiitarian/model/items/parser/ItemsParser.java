package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public class ItemsParser {
    
    private ItemParser mItemParser;
    
    public ItemsParser() {
        mItemParser = createItemParser();
    }
    
    public Items parse(JSONArray jsonArray) throws JSONException, MalformedURLException, ParseException {
        QiitarianLog.d("start items parse");
        Items items = new Items();
        
        int arrayLenght = jsonArray.length();
        for (int i = 0; i < arrayLenght; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Item item = mItemParser.parse(jsonObject);
            items.add(item);
        }
        
        QiitarianLog.d("end items parse");
        return items;
    }
    
    ItemParser createItemParser() {
        return new ItemParser();
    }
}
