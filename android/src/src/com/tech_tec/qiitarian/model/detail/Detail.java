package com.tech_tec.qiitarian.model.detail;

import com.tech_tec.qiitarian.model.User;

public class Detail {
    
    private User mUser;
    
    public Detail(User user) {
        mUser = user;
    }
    
    public String getUserName() {
       return mUser.getUserName();
    }
    
}
