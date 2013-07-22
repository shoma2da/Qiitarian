package com.tech_tec.qiitarian.model.auth;

public class Token {
    
    private String mToken;
    
    public Token(String token) {
        mToken = token;
    }
    
    @Override
    public String toString() {
        return mToken;
    }
    
}
