package com.tech_tec.qiitarian.model.user;

public class GithubName {
    
    private String mName;
    
    public GithubName(String name) {
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
