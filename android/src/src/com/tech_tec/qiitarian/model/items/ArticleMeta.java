package com.tech_tec.qiitarian.model.items;

public class ArticleMeta {
    
    private CreatedAt mCreatedAt;
    private Tags mTags;
    
    public ArticleMeta(CreatedAt createdAt, Tags tags) {
        mCreatedAt = createdAt;
        mTags = tags;
    }
    
    public String getCreatedAt() {
        return mCreatedAt.toString();
    }
    
    public String getTagsText() {
        return mTags.getTagsText();
    }
}
