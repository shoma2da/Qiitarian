package com.tech_tec.qiitarian.task.list;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.tech_tec.qiitarian.model.auth.http.HttpResponseWrapper;
import com.tech_tec.qiitarian.model.items.Items;
import com.tech_tec.qiitarian.model.items.http.ItemsClient;
import com.tech_tec.qiitarian.model.items.parser.ItemsParser;

class ItemsFetcher {
    
    public Items fetch() throws ClientProtocolException, IOException, IllegalStateException, JSONException, ParseException {
        ItemsClient client = createItemsClient();
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
    
    ItemsClient createItemsClient() {
        return new ItemsClient();
    }
    
    ItemsParser createItemsParser() {
        return new ItemsParser();
    }
}
