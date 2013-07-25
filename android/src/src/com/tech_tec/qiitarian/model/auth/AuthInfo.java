package com.tech_tec.qiitarian.model.auth;


public class AuthInfo {
    
    public static final AuthInfo NULL = new AuthInfo();
    
    private UrlName mUrlName;
    private Token mToken;
    
    private AuthInfo() {
    }
    
    public AuthInfo(UrlName urlName, Token token) {
        mUrlName = urlName;
        mToken = token;
    }
    
    public String getTokenStr() {
        return mToken.toString();
    }
    
    public String getUrlNameStr() {
        return mUrlName.toString();
    }
    
}
