package com.tech_tec.qiitarian.model.items;

public class Item {
    
    private ArticleTitle mArticleTitle;
    private UserName mUserName;
    
    public Item(ArticleTitle articleTitle, UserName userName) {
        mArticleTitle = articleTitle;
        mUserName = userName;
    }

    public void actWithArticleTitle(CommandWithArticleTitle command) {
        command.act(mArticleTitle);
    }
    
    public interface CommandWithArticleTitle {
        void act(ArticleTitle title);
    }
    
    public UserName getUserName() {
        return mUserName;
    }
}
