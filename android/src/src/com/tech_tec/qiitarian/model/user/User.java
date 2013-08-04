package com.tech_tec.qiitarian.model.user;

public class User {
    
    private UrlName mUrlName;
    private ProfileImage mProfileImage;
    private Description mDescription;
    
    public User(UrlName urlName, ProfileImage profileImage, Description description) {
        mUrlName = urlName;
        mProfileImage = profileImage;
        mDescription = description;
    }
    
}
