package com.tech_tec.qiitarian.model.items.meta;

import com.tech_tec.qiitarian.model.items.tags.Tags;

public class AdditionalMeta {
    private Tags mTags;
    private Counts mCounts;
    
    public AdditionalMeta(Tags tags, Counts counts) {
        mTags = tags;
        mCounts = counts;
    }
}
