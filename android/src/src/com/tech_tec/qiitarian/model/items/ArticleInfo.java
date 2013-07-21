package com.tech_tec.qiitarian.model.items;

public class ArticleInfo {
    
    private ArticleTitle mArticleTitle;
    private ArticleMeta mArticleMeta;
    
    public ArticleInfo(ArticleTitle articleTitle, ArticleMeta articleMeta) {
        mArticleTitle = articleTitle;
        mArticleMeta = articleMeta;
    }
    
    public String getArticleTitle() {
        return mArticleTitle.toString();
    }
    
    public String getCreatedAt() {
        return mArticleMeta.getCreatedAt();
    }
    
    public String getTagsText() {
        return mArticleMeta.getTagsText();
    }
}
