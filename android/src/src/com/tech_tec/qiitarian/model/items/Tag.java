package com.tech_tec.qiitarian.model.items;

public class Tag {
    
    private String mTagText;
    
    public Tag(String tagText) {
        mTagText = tagText;
    }
    
    @Override
    public String toString() {
        return mTagText;
    }
    
}
