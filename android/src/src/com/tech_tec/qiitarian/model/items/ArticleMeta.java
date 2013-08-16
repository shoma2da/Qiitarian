package com.tech_tec.qiitarian.model.items;

import java.util.Iterator;

public class ArticleMeta {
    
    private CreatedAt mCreatedAt;
    private Tags mTags;
    private ReactionCounts mReactionCounts;
    
    public ArticleMeta(CreatedAt createdAt, Tags tags, ReactionCounts reactionCounts) {
        mCreatedAt = createdAt;
        mTags = tags;
        mReactionCounts = reactionCounts;
    }
    
    public String getCreatedAt() {
        return mCreatedAt.toString();
    }
    
    public Iterator<Tag> getTagIterator() {
        return mTags.getTagIterator();
    }
    
    public int getCommentCount() {
        return mReactionCounts.getCommentCount();
    }
    
    public int getStockCount() {
        return mReactionCounts.getStockCount();
    }
}
