package com.tech_tec.qiitarian.util;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.junit.Before;
import org.junit.Test;

public class JsonHttpClientTest {
    
    private JsonHttpClient mClient;
    
    @Before
    public void setUp() {
        mClient = new JsonHttpClient();
        mClient.mRealClieant = mock(HttpClient.class);
        ClientConnectionManager mockConnectionManager = mock(ClientConnectionManager.class);
        when(mClient.mRealClieant.getConnectionManager()).thenReturn(mockConnectionManager);
    }
    
    @Test
    public void サーバに接続できるようにする() throws ClientProtocolException, IOException {
        //Run!
        mClient.execute(null);
        
        //確認
        verify(mClient.mRealClieant, times(1)).execute((HttpUriRequest)anyObject());
    }
    
    @Test
    public void 受け取った引数のリクエストを送る() throws ClientProtocolException, IOException {
        //Run!
        HttpUriRequest getRequest = new HttpGet();
        mClient.execute(getRequest);
        
        //確認
        verify(mClient.mRealClieant, times(1)).execute(getRequest);
    }
    
    @Test
    public void 通信後にきちんとfinishしていることを確認する() throws ClientProtocolException, IOException {
        //Run!
        mClient.execute(null);
        
        //確認
        verify(mClient.mRealClieant, times(1)).getConnectionManager();
        ClientConnectionManager manager = mClient.mRealClieant.getConnectionManager();
        verify(manager, times(1)).shutdown();
    }
}
