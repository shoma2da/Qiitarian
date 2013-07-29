package com.tech_tec.qiitarian.task.list;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.tech_tec.qiitarian.model.http.HttpResponseWrapper;
import com.tech_tec.qiitarian.model.items.Items;
import com.tech_tec.qiitarian.model.items.http.ItemsClient;
import com.tech_tec.qiitarian.model.items.parser.ItemsParser;

class ItemsFetcher {
    
    public Items fetch(int page) throws ClientProtocolException, IOException, IllegalStateException, JSONException, ParseException {
        ItemsClient client = createItemsClient(page);
        HttpResponseWrapper response = client.execute();
        
        return processResponse(response);
    }
    
    private Items processResponse(HttpResponseWrapper response) throws MalformedURLException, IllegalStateException, JSONException, IOException, ParseException {
        if (response.isOK()) {
            return createItemsParser().parse(response.toJSONArray());
        } else {
            return new Items();
        }
    }
    
    ItemsClient createItemsClient(int page) {
        return new ItemsClient(page);
    }
    
    ItemsParser createItemsParser() {
        return new ItemsParser();
    }
}
