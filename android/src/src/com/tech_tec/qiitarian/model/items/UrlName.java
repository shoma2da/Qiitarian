package com.tech_tec.qiitarian.model.items;

public class UrlName {
    
    private String mUserName;
    
    public UrlName(String userName) {
        mUserName = userName;
    }
    
    @Override
    public String toString() {
        return mUserName;
    }
    
}
