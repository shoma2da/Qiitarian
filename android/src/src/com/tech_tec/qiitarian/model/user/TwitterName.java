package com.tech_tec.qiitarian.model.user;

public class TwitterName {
    
    private String mName;
    
    public TwitterName(String name) {
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
