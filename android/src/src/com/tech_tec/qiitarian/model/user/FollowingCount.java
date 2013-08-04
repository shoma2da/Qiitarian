package com.tech_tec.qiitarian.model.user;

public class FollowingCount {
    
    private int mCount;
    
    public FollowingCount(int count) {
        mCount = count;
    }
    
    public int toInt() {
        return mCount;
    }
    
}
