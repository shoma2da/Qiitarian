package com.tech_tec.qiitarian.model.common;

import java.io.IOException;


import android.graphics.Bitmap;


public class User {
    
    private UserUrlName mUrlName;
    private UserProfileImg mUserProfileImg;
    
    public User(UserUrlName urlName, UserProfileImg userProfileImg) {
        mUrlName = urlName;
        mUserProfileImg = userProfileImg;
    }
    
    public Bitmap getIconImg() {
        return mUserProfileImg.getIconImg();
    }
    
    public Bitmap fetchIconImg() throws IOException {
        return mUserProfileImg.fetchImg();
    }
    
    public boolean hasIconImg() {
        return mUserProfileImg.hasIconImg();
    }
    
    public String getUserName() {
        return mUrlName.toString();
    }
    
}
