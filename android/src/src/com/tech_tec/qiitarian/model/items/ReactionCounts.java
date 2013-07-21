package com.tech_tec.qiitarian.model.items;

public class ReactionCounts {
    
    private CommentCount mCommentCount;
    private StockCount mStockCount;
    
    public ReactionCounts(CommentCount commentCount, StockCount stockCount) {
        mCommentCount = commentCount;
        mStockCount = stockCount;
    }
    
    public int getCommentCount() {
        return mCommentCount.toInt();
    }
    
    public int getStockCount() {
        return mStockCount.toInt();
    }
}
