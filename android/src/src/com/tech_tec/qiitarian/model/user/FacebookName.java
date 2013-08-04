package com.tech_tec.qiitarian.model.user;

public class FacebookName {
    
    private String mName;
    
    public FacebookName(String name) {
        mName = name;
    }
    
    @Override
    public String toString() {
        return mName;
    }
    
    public boolean isEmpty() {
        return mName == null || mName.equals("");
    }
    
}
