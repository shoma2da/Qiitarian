package com.tech_tec.qiitarian.model.items;


public class Item {
    
    private ArticleInfo mArticleInfo;
    private UserName mUserName;
    
    //TODO 位置がおかしい
    private StockCount mStockCount;
    private CommentCount mCommentCount;
    
    public Item(UserName userName, ArticleInfo articleInfo, StockCount stockCount, CommentCount commentCount) {
        mUserName = userName;
        mArticleInfo = articleInfo;
        mStockCount = stockCount;
        mCommentCount = commentCount;
    }

    public String getArticleTitle() {
        return mArticleInfo.getArticleTitle();
    }
    
    public String getUserName() {
        return mUserName.toString();
    }
    
    public String getCreatedAt() {
        return mArticleInfo.getCreatedAt();
    }
    
    public String getTagsText() {
        return mArticleInfo.getTagsText();
    }
    
    public int getStockCount() {
        return mStockCount.toInt();
    }
    
    public int getCommentCount() {
        return mCommentCount.toInt();
    }
}
