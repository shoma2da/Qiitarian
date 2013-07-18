package com.tech_tec.qiitarian.model.items;

import com.tech_tec.qiitarian.model.items.ArticleContent.CommandWithArticleTitle;
import com.tech_tec.qiitarian.model.items.meta.ArticleMeta;

public class Article {
    
    private ArticleMeta mMeta;
    private ArticleContent mContent;
    
    public Article(ArticleMeta meta, ArticleContent content) {
        mMeta = meta;
        mContent = content;
    }
    
    public void actWithArticleTitle(CommandWithArticleTitle command) {
        mContent.actWithArticleTitle(command);
    }
    
}
