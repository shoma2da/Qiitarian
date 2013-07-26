package com.tech_tec.qiitarian.model;

import java.io.IOException;

import com.tech_tec.qiitarian.model.items.UrlName;
import com.tech_tec.qiitarian.model.items.UserProfileImg;

import android.graphics.Bitmap;


public class User {
    
    private UrlName mUrlName;
    private UserProfileImg mUserProfileImg;
    
    public User(UrlName urlName, UserProfileImg userProfileImg) {
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
