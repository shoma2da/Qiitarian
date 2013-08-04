package com.tech_tec.qiitarian.model.common;

import java.io.Serializable;

public class UserUrlName implements Serializable {
    
    private static final long serialVersionUID = 4845175806161913015L;
    
    private String mUserName;
    
    public UserUrlName(String userName) {
        mUserName = userName;
    }
    
    @Override
    public String toString() {
        return mUserName;
    }
    
}
