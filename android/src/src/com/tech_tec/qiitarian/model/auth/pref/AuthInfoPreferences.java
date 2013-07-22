package com.tech_tec.qiitarian.model.auth.pref;

import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.Token;
import com.tech_tec.qiitarian.model.auth.UrlName;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthInfoPreferences {
    
    private static final String PREF_NAME = "authinfo.xml";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_TOKEN = "token";
    
    private SharedPreferences mPreferences;
    
    public AuthInfoPreferences(Context context) {
        mPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    
    public void put(AuthInfo authInfo) {
        mPreferences.edit()
                    .putString(KEY_USERNAME, authInfo.getUrlNameStr())
                    .putString(KEY_TOKEN, authInfo.getTokenStr())
                    .commit();
    }
    
    public AuthInfo get() {
        String urlName = mPreferences.getString(KEY_USERNAME, null);
        String token = mPreferences.getString(KEY_TOKEN, null);
        
        if (urlName == null || token == null) {
            return null;
        }
        
        return new AuthInfo(new UrlName(urlName), new Token(token));
    }
}
