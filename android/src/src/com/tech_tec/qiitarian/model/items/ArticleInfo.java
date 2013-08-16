package com.tech_tec.qiitarian.model.items;

import java.util.Iterator;

import com.tech_tec.qiitarian.model.common.ArticleTitle;

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
    
    public Iterator<Tag> getTagIterator() {
        return mArticleMeta.getTagIterator();
    }
    
    public int getCommentCount() {
        return mArticleMeta.getCommentCount();
    }
    
    public int getStockCount() {
        return mArticleMeta.getStockCount();
    }
}
