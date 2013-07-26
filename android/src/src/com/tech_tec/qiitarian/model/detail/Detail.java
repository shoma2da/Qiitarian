package com.tech_tec.qiitarian.model.detail;

import com.tech_tec.qiitarian.model.items.User;
import com.tech_tec.qiitarian.model.items.Uuid;

public class Detail {
    
    private User mUser;
    private Uuid mUuid;
    
    public Detail(Uuid uuid, User user) {
        mUuid = uuid;
        mUser = user;
    }
    
    public String getUserName() {
       return mUser.getUserName();
    }
    
}
