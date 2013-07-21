package com.tech_tec.qiitarian.model.items;


public class Item {
    
    private ArticleInfo mArticleInfo;
    private UserName mUserName;
    private StockCount mStockCount;
    
    public Item(UserName userName, ArticleInfo articleInfo, StockCount stockCount) {
        mUserName = userName;
        mArticleInfo = articleInfo;
        mStockCount = stockCount;
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
}
