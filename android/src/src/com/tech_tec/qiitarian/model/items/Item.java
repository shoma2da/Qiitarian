package com.tech_tec.qiitarian.model.items;


public class Item {
    
    private ArticleInfo mArticleInfo;
    private UserName mUserName;
    
    public Item(UserName userName, ArticleInfo articleInfo) {
        mUserName = userName;
        mArticleInfo = articleInfo;
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
}
