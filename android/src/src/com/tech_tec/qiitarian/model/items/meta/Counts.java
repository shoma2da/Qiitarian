package com.tech_tec.qiitarian.model.items.meta;

public class Counts {
    private StockCount mStockCount;
    private CommentCount mCommentCount;
    
    public Counts(StockCount stockCount, CommentCount commentCount) {
        mStockCount = stockCount;
        mCommentCount = commentCount;
    }
}
