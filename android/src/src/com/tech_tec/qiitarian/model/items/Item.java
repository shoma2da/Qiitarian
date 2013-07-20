package com.tech_tec.qiitarian.model.items;



public class Item {
    
    private ArticleTitle mArticleTitle;
    
    public Item(ArticleTitle articleTitle) {
        mArticleTitle = articleTitle;
    }

    public void actWithArticleTitle(CommandWithArticleTitle command) {
        command.act(mArticleTitle);
    }
    
    public interface CommandWithArticleTitle {
        void act(ArticleTitle title);
    }
    
    
    
    /*
    private Identifier mIdentifier;
    private Article mArticle;
    
    public Item(Identifier identifier, Article article) {
        mIdentifier = identifier;
        mArticle = article;
    }
    
    public void actWithArticleTitle(CommandWithArticleTitle command) {
        mArticle.actWithArticleTitle(command);
    }
    
    */
}
