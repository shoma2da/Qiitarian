package com.tech_tec.qiitarian.model.items;

public class ArticleInfo {
    
    private ArticleTitle mArticleTitle;
    private CreatedAt mCreatedAt;
    private Tags mTags;
    
    public ArticleInfo(ArticleTitle articleTitle, CreatedAt createdAt, Tags tags) {
        mArticleTitle = articleTitle;
        mCreatedAt = createdAt;
        mTags = tags;
    }
    
    public String getArticleTitle() {
        return mArticleTitle.toString();
    }
    
    public String getCreatedAt() {
        return mCreatedAt.toString();
    }
    
    public String getTagsText() {
        return mTags.getTagsText();
    }
}
