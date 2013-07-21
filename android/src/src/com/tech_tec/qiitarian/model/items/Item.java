package com.tech_tec.qiitarian.model.items;

import java.io.IOException;

import android.graphics.Bitmap;



public class Item {
    
    private ArticleInfo mArticleInfo;
    private UserName mUserName;
    private UserProfileImg mUserProfileImg;
    
    public Item(UserName userName, ArticleInfo articleInfo, UserProfileImg userProfileImg) {
        mUserName = userName;
        mArticleInfo = articleInfo;
        mUserProfileImg = userProfileImg;
    }

    public String getArticleTitle() {
        return mArticleInfo.getArticleTitle();
    }
    
    public String getUserName() {
        return mUserName.toString();
    }
    
    public String getCreatedAt() {
        return mArticleInfo.getCreatedAt();
    }
    
    public String getTagsText() {
        return mArticleInfo.getTagsText();
    }
    
    public int getStockCount() {
        return mArticleInfo.getStockCount();
    }
    
    public int getCommentCount() {
        return mArticleInfo.getCommentCount();
    }
    
    public Bitmap fetchIconImg() throws IOException {
        return mUserProfileImg.fetchImg();
    }
}
