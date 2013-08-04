package com.tech_tec.qiitarian.model.user;

public class User {
    
    private UrlName mUrlName;
    private ProfileImage mProfileImage;
    private Description mDescription;
    private FacebookName mFacebookName;
    private TwitterName mTwitterName;
    private GithubName mGithubName;
    
    public User(UrlName urlName, ProfileImage profileImage, Description description, FacebookName facebookName, TwitterName twitterName, GithubName githubName) {
        mUrlName = urlName;
        mProfileImage = profileImage;
        mDescription = description;
        mFacebookName = facebookName;
        mTwitterName = twitterName;
        mGithubName = githubName;
    }
    
}
