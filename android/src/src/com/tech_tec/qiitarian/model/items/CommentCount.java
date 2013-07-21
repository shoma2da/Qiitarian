package com.tech_tec.qiitarian.model.items;

public class CommentCount {
    
    private int mCommentCount;
    
    public CommentCount(int commentCount) {
        mCommentCount = commentCount;
    }
    
    public int toInt() {
        return mCommentCount;
    }
    
}
