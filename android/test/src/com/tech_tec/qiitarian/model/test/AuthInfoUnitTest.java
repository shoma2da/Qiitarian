package com.tech_tec.qiitarian.model.test;

import com.tech_tec.qiitarian.model.AuthInfo;
import com.tech_tec.qiitarian.model.LoginService;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.test.AndroidTestCase;

public class AuthInfoUnitTest extends AndroidTestCase {
    
    private Context mContext;
    private SharedPreferences mPreferences;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        //テスト用のPrefファイルを用意するコンテキストとしてモック化
        mContext = new ContextWrapper(getContext()) {
            @Override
            public SharedPreferences getSharedPreferences(String name, int mode) {
                mPreferences = super.getSharedPreferences("test_" + name, mode);
                return mPreferences;
            }
        };
        new AuthInfo(mContext, null); //Preferencesを取得するために空オブジェクトを作成
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        //テスト用Prefファイルをクリアする
        mPreferences.edit().clear().commit();
    }
    
    public void testServiceの入出力() {
        AuthInfo authInfo = new AuthInfo(mContext, null);
        
        authInfo.setService(LoginService.TWITTER);
        assertEquals("twitterサービスを入出力して取れる", LoginService.TWITTER, authInfo.getService());
        
        authInfo.setService(LoginService.GITHUB);
        assertEquals("githubサービスを入出力して取れる", LoginService.GITHUB, authInfo.getService());
        
        try {
            authInfo.setService(new LoginService() { @Override public String convert(String username) { return null; } });
            authInfo.getService();
            fail("非対応のサービスの場合は例外発生");
        } catch (IllegalArgumentException exception) {
        }
    }
    
    public void testユーザ名の入出力() {
        AuthInfo authInfo = new AuthInfo(mContext, null);
        
        assertNull("未設定ならnull", authInfo.getUsername());
        
        authInfo.setUsername("shoma2da");
        assertEquals("ユーザ名を正しく取れる", "shoma2da", authInfo.getUsername());
    }
    
    public void testトークンの入出力() {
        AuthInfo authInfo = new AuthInfo(mContext, null);
        
        assertNull("未設定ならnull", authInfo.getToken());
        
        authInfo.setToken("origin token is here");
        assertEquals("トークンを正しく取れる", "origin token is here", authInfo.getToken());
    }
}
