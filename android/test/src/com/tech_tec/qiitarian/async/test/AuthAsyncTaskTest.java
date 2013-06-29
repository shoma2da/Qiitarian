package com.tech_tec.qiitarian.async.test;

import static org.mockito.Mockito.*;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.content.Context;
import android.test.AndroidTestCase;

import com.tech_tec.qiitarian.api.ApiAccessor;
import com.tech_tec.qiitarian.async.AuthAsyncTask;
import com.tech_tec.qiitarian.async.AuthAsyncTask.OnAuthListener;
import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.LoginService;

public class AuthAsyncTaskTest extends AndroidTestCase {
    
    public void test認証成功() throws ClientProtocolException, IOException, JSONException {
        String username = "username";
        String password = "password";
        String token = "token";
        LoginService service = LoginService.GITHUB;
        
        AuthInfo result = mock(AuthInfo.class);
        when(result.getService()).thenReturn(service);
        when(result.getToken()).thenReturn(token);
        when(result.getUsername()).thenReturn(username);
        
        ApiAccessor accessor = mock(ApiAccessor.class);
        when(accessor.auth(username, password, service)).thenReturn(result);
        
        TestAuthAsyncTask asyncTask = new TestAuthAsyncTask(getContext(), accessor);
        OnAuthListener listener = mock(OnAuthListener.class);
        asyncTask.addOnAuthListener(listener);
        
        asyncTask.onPreExecute();
        AuthInfo authInfo = asyncTask.doInBackground(username, password, service.toString());
        asyncTask.onPostExecute(authInfo);
        
        verify(listener).onAuth(false, authInfo, true);
        assertEquals(username, authInfo.getUsername());
        assertEquals(token, authInfo.getToken());
        assertEquals(service, authInfo.getService());
    }
    
    public void test認証失敗() throws ClientProtocolException, IOException, JSONException {
        String username = "username";
        String password = "password";
        LoginService service = LoginService.TWITTER;
        
        AuthInfo result = mock(AuthInfo.class);
        when(result.getService()).thenReturn(service);
        when(result.getToken()).thenReturn(null);
        when(result.getUsername()).thenReturn(username);
        
        ApiAccessor accessor = mock(ApiAccessor.class);
        when(accessor.auth(username, password, service)).thenReturn(result);
        
        TestAuthAsyncTask asyncTask = new TestAuthAsyncTask(getContext(), accessor);
        OnAuthListener listener = mock(OnAuthListener.class);
        asyncTask.addOnAuthListener(listener);
        
        asyncTask.onPreExecute();
        AuthInfo authInfo = asyncTask.doInBackground(username, password, service.toString());
        asyncTask.onPostExecute(authInfo);
        
        verify(listener).onAuth(false, authInfo, false);
        assertEquals(username, authInfo.getUsername());
        assertNull(authInfo.getToken());
        assertEquals(service, authInfo.getService());
    }
    
    public void test通信エラー() throws ClientProtocolException, IOException, JSONException {
        String username = "username";
        String password = "password";
        LoginService service = LoginService.TWITTER;
        
        ApiAccessor accessor = mock(ApiAccessor.class);
        when(accessor.auth(username, password, service)).thenThrow(new JSONException(""));
        
        TestAuthAsyncTask asyncTask = new TestAuthAsyncTask(getContext(), accessor);
        OnAuthListener listener = mock(OnAuthListener.class);
        asyncTask.addOnAuthListener(listener);
        
        asyncTask.onPreExecute();
        AuthInfo authInfo = asyncTask.doInBackground(username, password, service.toString());
        asyncTask.onPostExecute(authInfo);
        
        verify(listener).onAuth(true, null, false);
    }

    private class TestAuthAsyncTask extends AuthAsyncTask {
        public TestAuthAsyncTask(Context context, ApiAccessor apiAccessor) {
            super(context, apiAccessor);
        }
        
        @Override
        public AuthInfo doInBackground(String... params) {
            return super.doInBackground(params);
        }
        
        @Override
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        public void onPostExecute(AuthInfo result) {
            super.onPostExecute(result);
        }
    }
    
}
