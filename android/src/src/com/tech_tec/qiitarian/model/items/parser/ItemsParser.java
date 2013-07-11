package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Items;

public class ItemsParser {

    public Items parse(JSONObject jsonObject) {
        return new Items();
    }

}
