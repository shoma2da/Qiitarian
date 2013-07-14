package com.tech_tec.qiitarian.util.http;

import static junit.framework.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class ItemsClientTest {
    
    @Test
    public void 投げるのはGetメソッドでURLはitems() {
        ItemsClient client = new ItemsClient();
        HttpUriRequest request = client.createRequest();
        
        assertEquals(request.getMethod(), "GET");
        assertEquals(request.getURI().toASCIIString(), "https://qiita.com/api/v1/items");
    }
    
    @Test
    public void デフォルトで使っているのはDefaultHttpClientか() {
        ItemsClient client = new ItemsClient();
        HttpClient wrapedClient = client.createHttpClient();
        
        assertEquals(DefaultHttpClient.class, wrapedClient.getClass());
    }
    
    @Test
    public void リクエストを投げる() throws ClientProtocolException, IOException {
        final HttpClient mockClient = mock(HttpClient.class);
        when(mockClient.execute((HttpUriRequest)any())).thenReturn(mock(HttpResponse.class));
        ItemsClient client = new ItemsClient() {
            @Override
            HttpClient createHttpClient() {
                return mockClient;
            }
        };
        
        ResponseData data = client.execute();
        assertNotNull(data);
    }
}
