package com.tech_tec.qiitarian.model.user.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.user.Description;
import com.tech_tec.qiitarian.model.user.FacebookName;
import com.tech_tec.qiitarian.model.user.FollowerCount;
import com.tech_tec.qiitarian.model.user.FollowingCount;
import com.tech_tec.qiitarian.model.user.GithubName;
import com.tech_tec.qiitarian.model.user.ProfileImage;
import com.tech_tec.qiitarian.model.user.TwitterName;
import com.tech_tec.qiitarian.model.user.UrlName;
import com.tech_tec.qiitarian.model.user.User;

public class UserParser {
    
    public User parse(JSONObject object) throws JSONException, MalformedURLException {
        UrlName urlName = new UrlNameParser().parse(object);
        ProfileImage profileImage = new ProfileImageParser().parse(object);
        Description description = new DescriptionParser().parse(object);
        FacebookName facebookName = new FacebookNameParser().parse(object);
        TwitterName twitterName = new TwitterNameParser().parse(object);
        GithubName githubName = new GithubNameParser().parse(object);
        FollowingCount followingCount = new FollowingCountParser().parse(object);
        FollowerCount followerCount = new FollowerCountParser().parse(object);
        
        return new User(urlName, profileImage, description, facebookName, twitterName, githubName, followingCount, followerCount);
    }
    
}
