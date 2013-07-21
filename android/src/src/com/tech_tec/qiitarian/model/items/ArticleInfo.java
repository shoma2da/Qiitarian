package com.tech_tec.qiitarian.model.items;

public class ArticleInfo {
    
    private ArticleTitle mArticleTitle;
    private CreatedAt mCreatedAt;
    
    public ArticleInfo(ArticleTitle articleTitle, CreatedAt createdAt) {
        mArticleTitle = articleTitle;
        mCreatedAt = createdAt;
    }
    
    
    public String getArticleTitle() {
        return mArticleTitle.toString();
    }
    
    public String getCreatedAt() {
        return mCreatedAt.toString();
    }
    
}
