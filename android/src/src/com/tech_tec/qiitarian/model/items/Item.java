package com.tech_tec.qiitarian.model.items;

public class Item {
    private Identifier mIdentifier;
    private Article mArticle;
    
    public Item(Identifier identifier, Article article) {
        mIdentifier = identifier;
        mArticle = article;
    }
}
