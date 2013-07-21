package com.tech_tec.qiitarian.model.items;


public class Item {
    
    private ArticleInfo mArticleInfo;
    private UserName mUserName;
    private Tags mTags;
    
    public Item(UserName userName, ArticleInfo articleInfo, Tags tags) {
        mUserName = userName;
        mArticleInfo = articleInfo;
        mTags = tags;
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
        return mTags.getTagsText();
    }
}
