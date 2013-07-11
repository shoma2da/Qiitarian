package com.tech_tec.qiitarian.util.http;

import static org.mockito.Mockito.*;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.util.http.QiitaJsonHttpClient;
import com.tech_tec.qiitarian.util.http.QiitaJsonService;

public class QiitaJsonServiceTest extends TestCase {
    
    public void testRateLimit() throws JSONException, ClientProtocolException, IOException {
        doTestRateLimit(130, 150);
        doTestRateLimit(140, 160);
    }
    
    private void doTestRateLimit(int expectedRemaining, int expectedLimit) throws JSONException, ClientProtocolException, IOException {
        QiitaJsonService service = new QiitaJsonService();
        QiitaJsonHttpClient mockClient = mock(QiitaJsonHttpClient.class);
        JSONObject mockJsonObject = new JSONObject(String.format("{remaining:%d, limit:%d}", expectedRemaining, expectedLimit));
        when(mockClient.fetchJson((HttpUriRequest)anyObject())).thenReturn(mockJsonObject);
        service.mClient = mockClient;
        
        JSONObject lateLimitJson = service.lateLimit();
        int remaining = lateLimitJson.getInt("remaining");
        int limit = lateLimitJson.getInt("limit");
        assertEquals(expectedRemaining, remaining);
        assertEquals(expectedLimit, limit);
    }
    
}
