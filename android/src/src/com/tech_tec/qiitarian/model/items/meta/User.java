package com.tech_tec.qiitarian.model.items.meta;

import java.net.URL;

public class User {
    
    private String mUrlName;
    private URL mProfileImgUrl;
    
    public User(String urlName, URL profileImgUrl) {
        mUrlName = urlName;
        mProfileImgUrl = profileImgUrl;
    }
    
}
