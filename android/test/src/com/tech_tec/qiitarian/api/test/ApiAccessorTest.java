package com.tech_tec.qiitarian.api.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.api.ApiAccessor;
import com.tech_tec.qiitarian.api.ApiAccessor.JSONObjectFactory;
import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.LoginService;

public class ApiAccessorTest extends TestCase {
    
    public void testログイン成功() throws JSONException, ClientProtocolException, IOException {
        String username = "shoma2da";
        String password = "hogehoge";
        String token = "abcde";
        
        final String url = String.format("https://qiita.com/api/v1/auth?url_name=%s&password=%s", username, password);
        JSONObject json = new JSONObject(String.format("{ \"token\" : \"%s\" }", token));
        
        JSONObjectFactory jsonObjectFactory = mock(JSONObjectFactory.class);
        final HttpRequestBase request = new HttpPost(url);
        when(jsonObjectFactory.create(request)).thenReturn(json);
        ApiAccessor accessor = new ApiAccessor(jsonObjectFactory) {
            @Override
            protected HttpRequestBase createAuthRequest(String argurl) {
                super.createAuthRequest(url);
                assertEquals(argurl, url);
                return request;
            }
        };
        
        AuthInfo info = accessor.auth(username, password, LoginService.TWITTER);
        assertEquals(info.getUsername(), username);
        assertEquals(info.getToken(), token);
        assertEquals(info.getService(), LoginService.TWITTER);
    }
    
    public void testログイン失敗() throws ClientProtocolException, IOException, JSONException {
        String username = "shoma2da";
        String password = "hogehoge";
        
        final String url = String.format("https://qiita.com/api/v1/auth?url_name=%s&password=%s", username, password);
        JSONObject json = new JSONObject("{}");
        
        JSONObjectFactory jsonObjectFactory = mock(JSONObjectFactory.class);
        final HttpRequestBase request = new HttpPost(url);
        when(jsonObjectFactory.create(request)).thenReturn(json);
        ApiAccessor accessor = new ApiAccessor(jsonObjectFactory) {
            @Override
            protected HttpRequestBase createAuthRequest(String argurl) {
                super.createAuthRequest(url);
                assertEquals(url, argurl);
                return request;
            }
        };
        
        AuthInfo info = accessor.auth(username, password, LoginService.TWITTER);
        assertEquals(info.getUsername(), username);
        assertNull(info.getToken());
        assertEquals(info.getService(), LoginService.TWITTER);
    }
    
}
