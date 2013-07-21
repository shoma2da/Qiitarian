package com.tech_tec.qiitarian.model.items;

import java.io.IOException;

import android.graphics.Bitmap;



public class Item {
    
    private ArticleInfo mArticleInfo;
    private User mUser;
    
    public Item(ArticleInfo articleInfo, User user) {
        mArticleInfo = articleInfo;
        mUser = user;
    }

    public String getArticleTitle() {
        return mArticleInfo.getArticleTitle();
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
        return mUser.fetchIconImg();
    }
    
    public String getUserName() {
        return mUser.getUserName();
    }
    
}
