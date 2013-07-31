package com.tech_tec.qiitarian.fragment.list;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.tech_tec.qiitarian.model.http.ClientBase;
import com.tech_tec.qiitarian.model.http.HttpResponseWrapper;
import com.tech_tec.qiitarian.model.items.Items;
import com.tech_tec.qiitarian.model.items.parser.ItemsParser;

public class ItemsFetcher {
    
    private ClientBase mClient;
    
    public ItemsFetcher(ClientBase client) {
        mClient = client;
    }
    
    public Items fetch(int page) throws ClientProtocolException, IOException, IllegalStateException, JSONException, ParseException {
        HttpResponseWrapper response = mClient.execute();
        
        return processResponse(response);
    }
    
    private Items processResponse(HttpResponseWrapper response) throws MalformedURLException, IllegalStateException, JSONException, IOException, ParseException {
        if (response.isOK()) {
            return createItemsParser().parse(response.toJSONArray());
        } else {
            return new Items();
        }
    }
    
    ItemsParser createItemsParser() {
        return new ItemsParser();
    }
}
