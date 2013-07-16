package com.tech_tec.qiitarian.fragment.content.list.task;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.tech_tec.qiitarian.model.items.Items;
import com.tech_tec.qiitarian.model.items.http.ItemsClient;
import com.tech_tec.qiitarian.model.items.http.ResponseData;
import com.tech_tec.qiitarian.model.items.parser.ItemsParser;

public class ItemsFetcher {
    
    public Items fetch() throws ClientProtocolException, IOException, IllegalStateException, JSONException {
        ItemsClient client = createItemsClient();
        ResponseData response = client.execute();
        
        try {
            return processResponse(response);
        } finally {
            response.getInputStream().close();
        }
    }
    
    private Items processResponse(ResponseData response) throws MalformedURLException, IllegalStateException, JSONException, IOException {
        if (response.isOK()) {
            return createItemsParser().parse(response.getInputStream());
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
