package com.tech_tec.qiitarian.model.items;

public class Item {
    
    private ArticleTitle mArticleTitle;
    private UserName mUserName;
    private CreatedAt mCreatedAt;
    
    public Item(ArticleTitle articleTitle, UserName userName, CreatedAt createdAt) {
        mArticleTitle = articleTitle;
        mUserName = userName;
        mCreatedAt = createdAt;
    }

    public String getArticleTitle() {
        return mArticleTitle.toString();
    }
    
    public String getUserName() {
        return mUserName.toString();
    }
    
    public String getCreatedAt() {
        return mCreatedAt.toString();
    }
}
