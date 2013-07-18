package com.tech_tec.qiitarian.model.items;

import com.tech_tec.qiitarian.model.items.ArticleContent.CommandWithArticleTitle;

public class Item {
    private Identifier mIdentifier;
    private Article mArticle;
    
    public Item(Identifier identifier, Article article) {
        mIdentifier = identifier;
        mArticle = article;
    }
    
    public void actWithArticleTitle(CommandWithArticleTitle command) {
        mArticle.actWithArticleTitle(command);
    }
    
}
