package com.tech_tec.qiitarian.util.http;

import static junit.framework.Assert.*;

import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Test;

public class RequestsTest {
    
    private Requests mRequests = new Requests();
    
    @Test
    public void itemsリクエストを正しく取得できるか() {
        HttpUriRequest request = mRequests.items();
        assertEquals(Requests.BASE_URL + "/items", request.getURI().toString());
    }
    
}
