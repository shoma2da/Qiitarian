package com.tech_tec.qiitarian.model.items;

public class Item {
    
    private ArticleTitle mArticleTitle;
    private UserName mUserName;
    
    public Item(ArticleTitle articleTitle, UserName userName) {
        mArticleTitle = articleTitle;
        mUserName = userName;
    }

    public String getArticleTitle() {
        return mArticleTitle.toString();
    }
    
    public String getUserName() {
        return mUserName.toString();
    }
}
