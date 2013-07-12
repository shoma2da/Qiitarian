package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONArray;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public class ItemsParser {
    
    public Items parse(JSONArray jsonArray) {
        Items items = new Items();
        
        int arrayLenght = jsonArray.length();
        for (int i = 0; i < arrayLenght; i++) {
            Item item = new Item();
            items.add(item);
        }
        
        return items;
    }
    
}
