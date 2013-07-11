package com.tech_tec.qiitarian.util.http;

import static junit.framework.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.tech_tec.qiitarian.util.http.QiitaJsonHttpClient;

public class QiitaJsonHttpClientTest {
    
    private QiitaJsonHttpClient mClient;
    
    @Before
    public void setUp() throws IllegalStateException, IOException {
        mClient = new QiitaJsonHttpClient();
        mClient.mRealClieant = mock(HttpClient.class);
        
        ClientConnectionManager mockConnectionManager = mock(ClientConnectionManager.class);
        HttpResponse mockResponse = mock(HttpResponse.class);
        HttpEntity mockEntity = mock(HttpEntity.class);
        InputStream mockInput = mock(InputStream.class);
        
        when(mClient.mRealClieant.getConnectionManager()).thenReturn(mockConnectionManager);
        when(mockEntity.getContent()).thenReturn(mockInput);
        when(mockResponse.getEntity()).thenReturn(mockEntity);
        when(mClient.mRealClieant.execute((HttpUriRequest)anyObject())).thenReturn(mockResponse);
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
    public void メンバのクライアントオブジェクトでnullポインターが出ないようにする() throws ClientProtocolException, IOException {
        QiitaJsonHttpClient client = new QiitaJsonHttpClient();
        assertNotNull(client.mRealClieant);
    }
    
    @Test
    public void レスポンスのInputStreamを取得する() throws IllegalStateException, IOException {
        //準備
        HttpUriRequest mockRequest = mock(HttpUriRequest.class);
        InputStream mockInput = mock(InputStream.class);
        when(mClient.mRealClieant.execute(mockRequest).getEntity().getContent()).thenReturn(mockInput);
        
        InputStream realInput = mClient.execute(mockRequest);
        assertEquals(mockInput, realInput);
    }
    
    @Test
    public void InputStreamからStringを読み出す() {
        InputStream dummyInput = new ByteArrayInputStream("hello".getBytes());
        assertEquals("hello", mClient.readContent(dummyInput));
        
        dummyInput = new ByteArrayInputStream("hello¥nhello".getBytes());
        assertEquals("hello¥nhello", mClient.readContent(dummyInput));
    }
    
    @Test
    public void JsonObjectを返却する() throws JSONException, ClientProtocolException, IOException {
        doTestReturnJsonObject("{\"query\":\"Pizza\",\"locations\":[94043,90210]}");
        doTestReturnJsonObject("{}");
        doTestReturnJsonObject("{ list:[ 1,2,3 ] }");
        doTestReturnJsonObject("{ pi:3.14 }");
    }
    
    private void doTestReturnJsonObject(String jsonText) throws ClientProtocolException, IOException, JSONException {
        HttpUriRequest mockRequest = mock(HttpUriRequest.class);
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse mockResponse = mock(HttpResponse.class);
        HttpEntity mockEntry = mock(HttpEntity.class);
        InputStream mockInput = new ByteArrayInputStream(jsonText.getBytes());
        
        when(mockClient.execute(mockRequest)).thenReturn(mockResponse);
        when(mockResponse.getEntity()).thenReturn(mockEntry);
        when(mockEntry.getContent()).thenReturn(mockInput);
        
        mClient.mRealClieant = mockClient;
        
        JSONObject resultJson = mClient.fetchJson(mockRequest);
        assertEquals(new JSONObject(jsonText).toString(), resultJson.toString());
    }
    
}
