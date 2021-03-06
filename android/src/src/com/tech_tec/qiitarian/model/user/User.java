package com.tech_tec.qiitarian.model.user;

import java.io.IOException;

import android.graphics.Bitmap;

import com.tech_tec.qiitarian.task.icon.IconFechable;

public class User implements IconFechable {
    
    private UrlName mUrlName;
    private ProfileImage mProfileImage;
    private Description mDescription;
    private FacebookName mFacebookName;
    private TwitterName mTwitterName;
    private GithubName mGithubName;
    private FollowingCount mFollowingCount;
    private FollowerCount mFollowerCount;
    private ItemCount mItemCount;
    
    public User(UrlName urlName, ProfileImage profileImage, Description description, FacebookName facebookName, TwitterName twitterName, GithubName githubName, FollowingCount followingCount, FollowerCount followerCount, ItemCount itemCount) {
        mUrlName = urlName;
        mProfileImage = profileImage;
        mDescription = description;
        mFacebookName = facebookName;
        mTwitterName = twitterName;
        mGithubName = githubName;
        mFollowingCount = followingCount;
        mFollowerCount = followerCount;
        mItemCount = itemCount;
    }
    
    public String getDescription() {
        return mDescription.toString();
    }
    
    public boolean hasDescription() {
        return (mDescription != null) && (mDescription.isEmpty() == false);
    }
    
    public String getNameStr() {
        return mUrlName.toString();
    }

    @Override
    public Bitmap fetchIconImg() throws IOException {
        return mProfileImage.fetchImg();
    }
    
    public boolean hasFacebookNmae() {
        return (mFacebookName != null) && (mFacebookName.isEmpty() == false);
    }
    
    public String getFacebookName() {
        return mFacebookName.toString();
    }
    
    public boolean hasTwitterName() {
        return (mTwitterName != null) && (mTwitterName.isEmpty() == false);
    }
    
    public String getTwitterName() {
        return mTwitterName.toString();
    }
    
    public boolean hasGithubName() {
        return (mGithubName != null) && (mGithubName.isEmpty() == false);
    }
    
    public String getGithubName() {
        return mGithubName.toString();
    }
    
    public int getFollowingCount() {
        return mFollowingCount.toInt();
    }
    
    public int getFollowerCount() {
        return mFollowerCount.toInt();
    }
    
    public int getItemCount() {
        return mItemCount.toInt();
    }
    
}
