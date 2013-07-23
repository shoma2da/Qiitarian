package com.tech_tec.qiitarian.model.items.http;

import static junit.framework.Assert.*;

import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Test;

public class ItemsClientTest {
    
    @Test
    public void 投げるのはGetメソッドでURLはitems() {
        ItemsClient client = new ItemsClient();
        HttpUriRequest request = client.createRequest();
        
        assertEquals(request.getMethod(), "GET");
        assertEquals(request.getURI().toASCIIString(), "https://qiita.com/api/v1/items");
    }
    
}
