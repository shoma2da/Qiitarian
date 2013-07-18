package com.tech_tec.qiitarian.model.items;

public class ArticleContent {
    
    private ArticleTitle mTitle;
    private String mBody;
    
    public ArticleContent(ArticleTitle title, String body) {
        mTitle = title;
        mBody = body;
    }
    
    public void actWithArticleTitle(CommandWithArticleTitle command) {
        command.act(mTitle);
    }
    
    public interface CommandWithArticleTitle {
        void act(ArticleTitle articleTitle);
    }
}
