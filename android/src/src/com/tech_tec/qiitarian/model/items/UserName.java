package com.tech_tec.qiitarian.model.items;

public class UserName {
    
    private String mUserName;
    
    public UserName(String userName) {
        mUserName = userName;
    }
    
    @Override
    public String toString() {
        return mUserName;
    }
    
}
