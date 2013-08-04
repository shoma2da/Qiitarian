package com.tech_tec.qiitarian.model.user;

public class User {
    
    private UrlName mUrlName;
    private ProfileImage mProfileImage;
    private Description mDescription;
    private FacebookName mFacebookName;
    
    public User(UrlName urlName, ProfileImage profileImage, Description description, FacebookName facebookName) {
        mUrlName = urlName;
        mProfileImage = profileImage;
        mDescription = description;
        mFacebookName = facebookName;
    }
    
}
