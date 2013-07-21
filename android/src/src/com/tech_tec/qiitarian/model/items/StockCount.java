package com.tech_tec.qiitarian.model.items;

public class StockCount {
    
    private int mStockCount;
    
    public StockCount(int stockCount) {
        mStockCount = stockCount;
    }
    
    public int toInt() {
        return mStockCount;
    }
    
}
